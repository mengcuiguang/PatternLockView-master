package com.meng.rxpatternlockview.events;

import com.meng.patternlockview.PatternLockView;

import java.util.List;

/**
 * Created by aritraroy on 01/04/17.
 */

public class PatternLockProgressEvent extends BasePatternLockEvent {

    public PatternLockProgressEvent(List<PatternLockView.Dot> pattern) {
        super(pattern);
    }
}