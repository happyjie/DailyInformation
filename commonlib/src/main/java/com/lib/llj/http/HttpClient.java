package com.lib.llj.http;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by llj on 2017/12/13.
 */

public class HttpClient {

    private Context context;
    private boolean isDebug = true;
    private static HttpClient instance;

    public static HttpClient getInstance() {
        if (null == instance) {
            synchronized (HttpClient.class) {
                if (null == instance) {
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化，在application的onCreate里调用
     *
     * @param context
     * @param isDebug
     */
    public void init(Context context, boolean isDebug) {
        this.context = context;
        this.isDebug = isDebug;
    }

    public Retrofit getRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        if (!TextUtils.isEmpty(baseUrl)) {
            builder.baseUrl(baseUrl);
        }

        return builder.addConverterFactory(GsonConverterFactory.create())     //json转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//使Retrofit可以与RxJava结合使用
                .client(getOkHttpClient())  //设置网络请求客户端
                .build();

    }

    private OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(isDebug ? HttpLoggingInterceptor.Level.BASIC : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(new HttpHeadInterceptor())
                .hostnameVerifier(new HostnameVerifier() {  //在握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接。此处默认接受所有域名，有安全风险。
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

        //添加证书验证
        //在使用HttpsURLConnection发起 HTTPS 请求的时候，提供了一个自定义的X509TrustManager，未实现安全校验逻辑，
        //如果不提供自定义的X509TrustManager，代码运行起来可能会报SSLHandshakeException异常
        //此处暂时接受任意客户端，这是一种不安全的方式
        try {
            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                    //do nothing，接受任意客户端证书
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                    //do nothing，接受任意服务端证书
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{tm}, new SecureRandom());
            okBuilder.sslSocketFactory(sslContext.getSocketFactory());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return okBuilder.build();
    }

    class HttpHeadInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.addHeader("Accept", "application/json;versions=1");
            if (NetworkUtils.isNetworkAvailable(context)) {
                int maxAge = 60;
                builder.addHeader("Cache-Control", "public, max-age=" + maxAge);
            } else {
                int maxStale = 60 * 60 * 24 * 28;
                builder.addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
            }
            // 可添加token
//            if (listener != null) {
//                builder.addHeader("token", listener.getToken());
//            }
            // 如有需要，添加请求头
//            builder.addHeader("a", HttpHead.getHeader(request.method()));
            return chain.proceed(builder.build());
        }
    }
}
