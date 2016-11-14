package spa.lyh.bannerbutton.utils;

import android.content.Context;

/**
 * Created by liyuhao on 2016/11/11.
 */

public class DensityUtil {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)<p>
     * According to the resolution of the mobile phone from the DP unit to become PX (pixels)<p>
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp<p>
     * According to the resolution of the mobile phone from the PX (pixels) unit to become DP<p>
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
