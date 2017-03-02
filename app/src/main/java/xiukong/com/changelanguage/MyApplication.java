package xiukong.com.changelanguage;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import xiukong.com.changelanguage.utils.LanguageUtil;

/**
 * Created by Monkey on 2017/3/1.
 */

public class MyApplication extends Application{

    SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        initLanguage();
    }

    private void initLanguage() {
        sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        int languageType = sharedPreferences.getInt("LanguageType",LanguageUtil.FOLLOW_SYSTEM);
        LanguageUtil.changeAppLanguage(getResources(),languageType);
    }
}
