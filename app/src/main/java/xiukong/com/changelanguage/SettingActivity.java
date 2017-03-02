package xiukong.com.changelanguage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xiukong.com.changelanguage.utils.LanguageUtil;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnFollow;
    private Button mBtnChinese;
    private Button mBtnEnglish;
    private Button mBtnTraditional;

    private SharedPreferences sharedPreferences;

    private int languageType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initData();
        initView();
        initListener();
    }

    private void initView(){
        mBtnFollow = (Button) findViewById(R.id.id_btn_setting_follow);
        mBtnChinese = (Button) findViewById(R.id.id_btn_setting_chinese);
        mBtnEnglish = (Button) findViewById(R.id.id_btn_setting_english);
        mBtnTraditional = (Button) findViewById(R.id.id_btn_setting_traditional_chinese);
    }

    private void initListener() {
        mBtnFollow.setOnClickListener(this);
        mBtnChinese.setOnClickListener(this);
        mBtnEnglish.setOnClickListener(this);
        mBtnTraditional.setOnClickListener(this);
    }

    private void initData(){
        sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        languageType = sharedPreferences.getInt("LanguageType",LanguageUtil.FOLLOW_SYSTEM);
    }

    @Override
    public void onClick(View v) {

        int choseType = LanguageUtil.FOLLOW_SYSTEM;

        switch (v.getId()){
            case R.id.id_btn_setting_follow:
                choseType = LanguageUtil.FOLLOW_SYSTEM;
                break;
            case R.id.id_btn_setting_chinese:
                choseType = LanguageUtil.SIMPLIFIED_CHINESE;
                break;
            case R.id.id_btn_setting_english:
                choseType = LanguageUtil.ENGLISH;
                break;
            case R.id.id_btn_setting_traditional_chinese:
                choseType = LanguageUtil.TRADITIONAL_CHINESE;
                break;
        }
        if (choseType == languageType) {
            Toast.makeText(this,"选择无变化",Toast.LENGTH_LONG).show();
            return;
        }
        LanguageUtil.changeAppLanguage(getResources(),choseType);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("LanguageType",choseType);
        editor.commit();
        restart();
    }

    /**
     * 重启app
     */
    private void restart() {
        Intent i = getPackageManager()
                .getLaunchIntentForPackage(getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
