package xiukong.com.changelanguage.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import xiukong.com.changelanguage.utils.LanguageUtil;

/**
 * Created by Monkey on 2017/3/2.
 */

public class LocalChangedReceiver extends BroadcastReceiver{

    SharedPreferences sharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        }
        int languageType = sharedPreferences.getInt("LanguageType", LanguageUtil.FOLLOW_SYSTEM);
        LanguageUtil.changeAppLanguage(context.getResources(),languageType);
    }
}
