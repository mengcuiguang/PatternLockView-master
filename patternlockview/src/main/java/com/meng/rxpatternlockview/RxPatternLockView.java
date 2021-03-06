package com.meng.rxpatternlockview;

import com.meng.patternlockview.PatternLockView;
import com.meng.rxpatternlockview.events.PatternLockCompleteEvent;
import com.meng.rxpatternlockview.events.PatternLockCompoundEvent;
import com.meng.rxpatternlockview.events.PatternLockProgressEvent;
import com.meng.rxpatternlockview.observables.PatternLockViewCompleteObservable;
import com.meng.rxpatternlockview.observables.PatternLockViewCompoundObservable;
import com.meng.rxpatternlockview.observables.PatternLockViewProgressObservable;

import io.reactivex.Observable;

import static com.meng.rxpatternlockview.utils.Preconditions.checkNotNull;

/**
 * Created by aritraroy on 27/03/17.
 */

public class RxPatternLockView {

    /**
     * Create an observable for all events of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     */
    public static Observable<PatternLockCompoundEvent> patternChanges(PatternLockView patternLockView) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewCompoundObservable(patternLockView, false);
    }

    /**
     * Create an observable for all events of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     * <p>
     * <em>Note:</em> A value will be emitted immediately on subscribe.
     */
    public static Observable<PatternLockCompoundEvent> patternChanges(PatternLockView patternLockView,
                                                                      boolean emitInitialValue) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewCompoundObservable(patternLockView, emitInitialValue);
    }

    /**
     * Create an observable for only the pattern complete event of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     */
    public static Observable<PatternLockCompleteEvent> patternComplete(PatternLockView patternLockView) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewCompleteObservable(patternLockView, false);
    }

    /**
     * Create an observable for only the pattern complete event of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     * <p>
     * <em>Note:</em> A value will be emitted immediately on subscribe.
     */
    public static Observable<PatternLockCompleteEvent> patternComplete(PatternLockView patternLockView,
                                                                       boolean emitInitialValues) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewCompleteObservable(patternLockView, emitInitialValues);
    }

    /**
     * Create an observable for only the pattern progress event of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     */
    public static Observable<PatternLockProgressEvent> patternProgress(PatternLockView patternLockView) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewProgressObservable(patternLockView, false);
    }

    /**
     * Create an observable for only the pattern progress event of this {@code view}.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}.
     * Unsubscribe to free this reference.
     * <p>
     * <em>Note:</em> A value will be emitted immediately on subscribe.
     */
    public static Observable<PatternLockProgressEvent> patternProgress(PatternLockView patternLockView,
                                                                       boolean emitInitialValues) {
        checkNotNull(patternLockView, "view == null");
        return new PatternLockViewProgressObservable(patternLockView, emitInitialValues);
    }
}
