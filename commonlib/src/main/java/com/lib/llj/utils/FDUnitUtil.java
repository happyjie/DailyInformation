package com.lib.llj.utils;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

/**
 * 单位转换帮助类
 * 
 * @author hb
 * 
 */
public class FDUnitUtil {

	public static int dp2px(Context context, float dipValue) {
		if (context != null) {

			if ((float) LayoutParams.FILL_PARENT == dipValue) {
				return LayoutParams.FILL_PARENT;
			}

			if ((float) LayoutParams.WRAP_CONTENT == dipValue) {
				return LayoutParams.WRAP_CONTENT;
			}

			final float scale = context.getResources().getDisplayMetrics().density;
			return (int) (dipValue * scale + 0.5f);
		}
		return (int) dipValue;
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * 
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(float pxValue, Context context) {
		return (int) (pxValue / context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param spValue
	 * @return
	 */
	public static int sp2px(float spValue, Context context) {
		return (int) (spValue * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
	}

	public static int px2dp(Context context, float pxValue) {
		if (context != null) {
			final float scale = context.getResources().getDisplayMetrics().density;
			return (int) (pxValue / scale + 0.5f);
		}
		return (int) pxValue;
	}
}
