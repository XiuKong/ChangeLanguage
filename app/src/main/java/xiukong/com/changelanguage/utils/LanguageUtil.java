package xiukong.com.changelanguage.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by Monkey on 2017/3/1.
 */

public class LanguageUtil {

    public final static int FOLLOW_SYSTEM = 0;
    public final static int SIMPLIFIED_CHINESE = 1;
    public final static int ENGLISH = 2;
    public final static int TRADITIONAL_CHINESE = 3;

    /**
     * 修改语言设置
     * @param resources
     * @param type
     */
    public static void changeAppLanguage(Resources resources, int type) {
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (type == LanguageUtil.SIMPLIFIED_CHINESE) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        }  else if (type == LanguageUtil.ENGLISH) {
            config.locale = Locale.US;
        } else if (type == TRADITIONAL_CHINESE){
            config.locale = Locale.TRADITIONAL_CHINESE;
        }else {
            config.locale = Locale.getDefault();
        }
        resources.updateConfiguration(config, dm);
    }

}
