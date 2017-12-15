package com.story.happyjie.dailyinformation.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by llj on 2017/12/15.
 */

public class NewsContentBean {

    /**
     * abstract : 超级女声出来的何洁本来绯闻很少，但是这段时间因为和丈夫赫子铭离婚案件正在开庭，因此也成为网友和粉丝们关注的焦点。今天何洁在网上发文称诉求：从来就是孩子我养，从未要求男方净身出户，相信法律的公正！
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_sub_type : 0
     * article_type : 0
     * article_url : http://toutiao.com/group/6498657160266777102/
     * ban_comment : 0
     * behot_time : 1513318132
     * bury_count : 0
     * cell_flag : 11
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 0
     * cursor : 1513318132000
     * digg_count : 0
     * display_url : http://toutiao.com/group/6498657160266777102/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:388630543","is_selected":false,"name":"拉黑作者:疯帽子先生"},{"id":"2:11384965","is_selected":false,"name":"不想看:明星八卦"},{"id":"6:15899","is_selected":false,"name":"不想看:何洁"},{"id":"6:2947260","is_selected":false,"name":"不想看:赫子铭"}]
     * forward_info : {"forward_count":1}
     * gallary_image_count : 8
     * group_id : 6498657160266777102
     * has_image : true
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 1
     * image_list : [{"height":300,"uri":"list/4e5b000386c8df958fae","url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"}],"width":534},{"height":345,"uri":"list/4e6100003344cc49b6ed","url":"http://p1.pstatp.com/list/300x196/4e6100003344cc49b6ed.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/4e6100003344cc49b6ed.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e6100003344cc49b6ed.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e6100003344cc49b6ed.webp"}],"width":614},{"height":393,"uri":"list/4e5c000341d166d7a81c","url":"http://p1.pstatp.com/list/300x196/4e5c000341d166d7a81c.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/4e5c000341d166d7a81c.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e5c000341d166d7a81c.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e5c000341d166d7a81c.webp"}],"width":700}]
     * is_subject : false
     * item_id : 6498657160266777102
     * item_version : 0
     * keywords : 何洁,净身出户,粉丝,赫子铭,超级女声
     * level : 0
     * log_pb : {"impr_id":"20171215140852010008060131490EAF"}
     * media_info : {"avatar_url":"http://p8.pstatp.com/large/2c5f00167a4f5ac175f6","follow":false,"is_star_user":false,"media_id":1564750676220930,"name":"疯帽子先生","recommend_reason":"","recommend_type":0,"user_id":59120984291,"user_verified":false,"verified_content":""}
     * media_name : 疯帽子先生
     * middle_image : {"height":300,"uri":"list/4e5b000386c8df958fae","url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"}],"width":534}
     * publish_time : 1513122844
     * read_count : 297
     * rid : 20171215140852010008060131490EAF
     * share_count : 0
     * share_url : http://m.toutiao.com/a6498657160266777102/?iid=0&app=news_article
     * show_more : null
     * show_portrait : false
     * show_portrait_article : false
     * source : 疯帽子先生
     * source_icon_style : 6
     * source_open_url : sslocal://profile?uid=59120984291
     * tag : news_entertainment
     * tag_id : 6498657160266777102
     * tip : 0
     * title : 何洁霸气回应离婚，赫子铭要净身出户：拿着钱有多远滚多远！
     * ugc_recommend : {"activity":"","reason":""}
     * url : http://toutiao.com/group/6498657160266777102/
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/2c5f00167a4f5ac175f6","description":"热锅上的大象，精彩与您同分享！","follow":false,"follower_count":0,"name":"疯帽子先生","user_id":59120984291,"user_verified":false}
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     * video_style : 0
     */

    @SerializedName("abstract")
    private String abstractX;
    private int aggr_type;
    private boolean allow_download;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private int ban_comment;
    private int behot_time;
    private int bury_count;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private int comment_count;
    private long cursor;
    private int digg_count;
    private String display_url;
    private ForwardInfoBean forward_info;
    private int gallary_image_count;
    private long group_id;
    private boolean has_image;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private int hot;
    private int ignore_web_transform;
    private boolean is_subject;
    private long item_id;
    private int item_version;
    private String keywords;
    private int level;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private MiddleImageBean middle_image;
    private int publish_time;
    private int read_count;
    private String rid;
    private int share_count;
    private String share_url;
    private Object show_more;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;
    private List<ImageListBean> image_list;

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getShow_more() {
        return show_more;
    }

    public void setShow_more(Object show_more) {
        this.show_more = show_more;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 1
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 20171215140852010008060131490EAF
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p8.pstatp.com/large/2c5f00167a4f5ac175f6
         * follow : false
         * is_star_user : false
         * media_id : 1564750676220930
         * name : 疯帽子先生
         * recommend_reason :
         * recommend_type : 0
         * user_id : 59120984291
         * user_verified : false
         * verified_content :
         */

        private String avatar_url;
        private boolean follow;
        private boolean is_star_user;
        private long media_id;
        private String name;
        private String recommend_reason;
        private int recommend_type;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 300
         * uri : list/4e5b000386c8df958fae
         * url : http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"}]
         * width : 534
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason :
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/2c5f00167a4f5ac175f6
         * description : 热锅上的大象，精彩与您同分享！
         * follow : false
         * follower_count : 0
         * name : 疯帽子先生
         * user_id : 59120984291
         * user_verified : false
         */

        private String avatar_url;
        private String description;
        private boolean follow;
        private int follower_count;
        private String name;
        private long user_id;
        private boolean user_verified;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ImageListBean {
        /**
         * height : 300
         * uri : list/4e5b000386c8df958fae
         * url : http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb3.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"},{"url":"http://pb9.pstatp.com/list/300x196/4e5b000386c8df958fae.webp"}]
         * width : 534
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p1.pstatp.com/list/300x196/4e5b000386c8df958fae.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
