package com.meng.patternlockdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.meng.patternlockview.PatternLockView;
import com.meng.patternlockview.listener.PatternLockViewListener;
import com.meng.patternlockview.utils.PatternLockUtils;
import com.meng.patternlockview.utils.ResourceUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PatternLockView mPatternLockView, mPatternProfileImage;

    int times = 0;// 绘制次数
    String firstPsd = "";// 本地记录第一次绘制的密码

    private PatternLockViewListener mPatternLockViewListener = new PatternLockViewListener() {
        @Override
        public void onStarted() {
        }

        @Override
        public void onProgress(List<PatternLockView.Dot> progressPattern) {
        }

        @Override
        public void onComplete(List<PatternLockView.Dot> pattern) {
            if (pattern != null && pattern.size() <= 3) {
                // 连接小于三个点

                profile_name.setText("亲,至少连接四个点");
                mPatternLockView.clearPattern();
            } else {
                // 连接大于三个点

                String psd = PatternLockUtils.patternToString(mPatternLockView, pattern);

                mPatternProfileImage.setPattern(mPatternProfileImage.getPatternViewMode(), pattern);
                if (times == 0) {
                    //记录第一次绘制的密码

                    firstPsd = psd;
                    profile_name.setText("再次绘制解锁图案");
                    times++;
                } else if (times == 1) {
                    //记录第二次绘制的密码

                    if (TextUtils.equals(firstPsd, psd)) {
                        profile_name.setText("Welcome");
                        Toast.makeText(MainActivity.this, "绘制完成，进入界面", Toast.LENGTH_SHORT).show();
                    } else {
                        profile_name.setText("与第一次绘制不一致，请重新绘制");
                    }
                    mPatternLockView.clearPattern();
                }
            }
        }

        @Override
        public void onCleared() {
        }
    };
    private TextView profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        profile_name = (TextView) findViewById(R.id.profile_name);

        mPatternLockView = (PatternLockView) findViewById(R.id.patter_lock_view);
        mPatternProfileImage = (PatternLockView) findViewById(R.id.profile_image);
        mPatternLockView.setDotCount(3);
        mPatternLockView.setDotNormalSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size));
        mPatternLockView.setDotSelectedSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size));
        mPatternLockView.setPathWidth((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width));
        mPatternLockView.setAspectRatioEnabled(true);
        mPatternLockView.setAspectRatio(PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS);
        mPatternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
        mPatternLockView.setDotAnimationDuration(150);
        mPatternLockView.setPathEndAnimationDuration(100);
        mPatternLockView.setCorrectStateColor(ResourceUtils.getColor(this, R.color.white));
        mPatternLockView.setInStealthMode(false);
        mPatternLockView.setTactileFeedbackEnabled(true);
        mPatternLockView.setInputEnabled(true);
        mPatternLockView.addPatternLockListener(mPatternLockViewListener);
    }
}
