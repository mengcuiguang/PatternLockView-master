炫酷的手势解锁

![image](https://github.com/mengcuiguang/PatternLockView-master/blob/master/test.gif )  

原文作者：https://github.com/aritraroy/PatternLockView

使用：
    本文将原创中的库进行了合并，并添加些许小逻辑，使用起来更加方便~
    
1、布局文件

    <com.meng.patternlockview.PatternLockView
        android:id="@+id/patter_lock_view"
        android:layout_width="280dp"
        android:layout_height="280dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="16dp"
        app:aspectRatio="square"
        app:aspectRatioEnabled="true"
        app:dotAnimationDuration="150"
        app:dotCount="3"/>

2、MainActivity

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
        
    
