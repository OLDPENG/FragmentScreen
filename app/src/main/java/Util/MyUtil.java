package Util;

import android.app.Activity;
import android.content.res.Configuration;

public class MyUtil {

    // 判断Activitu横竖屏状态
    public static final boolean isScreenChange(Activity activity) {

        Configuration mConfiguration = activity.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向

        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            //横屏
            return true;
        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
            //竖屏
            return false;
        }
        return false;
    }
}
