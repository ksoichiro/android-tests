/*
 * Copyright (c) 2013 Soichiro Kashima
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.blogspot.ksoichiro.android.sample.transition.test;

import com.blogspot.ksoichiro.android.sample.transition.Fragment1;
import com.blogspot.ksoichiro.android.sample.transition.Fragment2;
import com.blogspot.ksoichiro.android.sample.transition.MainActivity;
import com.blogspot.ksoichiro.android.sample.transition.R;
import com.blogspot.ksoichiro.android.sample.transition.SecondActivity;

import android.app.Instrumentation.ActivityMonitor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.KeyEvent;

/**
 * 画面遷移のテスト。
 * 
 * @author Soichiro Kashima
 */
public class NormalTransitionTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public NormalTransitionTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // キーの送信を可能にする
        setActivityInitialTouchMode(true);
    }

    public void testNormalTransition() {
        // テスト対象Activityをモニタに登録
        ActivityMonitor monitorMain = new ActivityMonitor(
                MainActivity.class.getCanonicalName(), null, false);
        ActivityMonitor monitorSecond = new ActivityMonitor(
                SecondActivity.class.getCanonicalName(), null, false);
        getInstrumentation().addMonitor(monitorMain);
        getInstrumentation().addMonitor(monitorSecond);

        // 初期状態のFragmentのBackStackがないことを確認
        FragmentActivity activity = (FragmentActivity) getActivity();
        FragmentManager fm = activity.getSupportFragmentManager();
        assertEquals(0, fm.getBackStackEntryCount());

        // 初期状態のFragmentを確認
        Fragment frag = fm.findFragmentByTag("tag");
        assertNotNull(frag);
        assertEquals(Fragment1.class, frag.getClass());

        // 画面遷移(Fragment)するボタンをタップ
        TouchUtils.tapView(this, getActivity().findViewById(R.id.btnFrag1));
        getInstrumentation().waitForIdleSync();

        // BackStackにFragmentが追加された(＝戻れる)ことを確認
        assertEquals(1, fm.getBackStackEntryCount());

        // 画面遷移(Fragment)したことを確認
        frag = fm.findFragmentByTag("tag");
        assertNotNull(frag);
        assertEquals(Fragment2.class, frag.getClass());

        // 画面遷移(Activity)するボタンをタップ
        TouchUtils.tapView(this, getActivity().findViewById(R.id.btnFrag2));
        getInstrumentation().waitForMonitorWithTimeout(monitorSecond, 2000);

        // 指定のActivityに遷移したことを確認
        assertEquals(1, monitorSecond.getHits());

        // バックキーを押下
        sendKeys(KeyEvent.KEYCODE_BACK);
        getInstrumentation().waitForIdleSync();

        // 前画面(Activity)に戻ったことを確認
        assertEquals(1, monitorMain.getHits());

        // 遷移前のFragmentとBackStackが維持されていることを確認
        activity = (FragmentActivity) monitorMain.getLastActivity();
        fm = activity.getSupportFragmentManager();
        assertEquals(1, fm.getBackStackEntryCount());
        frag = fm.findFragmentByTag("tag");
        assertNotNull(frag);
        assertEquals(Fragment2.class, frag.getClass());

        // バックキーを押下
        sendKeys(KeyEvent.KEYCODE_BACK);
        getInstrumentation().waitForIdleSync();

        // 呼び出し元のFragmentが維持され、BackStackが空になっていることを確認
        assertEquals(0, fm.getBackStackEntryCount());
        frag = fm.findFragmentByTag("tag");
        assertNotNull(frag);
        assertEquals(Fragment1.class, frag.getClass());
    }

}
