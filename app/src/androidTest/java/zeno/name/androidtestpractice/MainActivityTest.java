package zeno.name.androidtestpractice;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author 陈治谋 (513500085@qq.com)
 * @since 16/8/8
 */
@RunWith(AndroidJUnit4.class)//让测试运行与 AndroidJUnit4测试环境
@LargeTest
public class MainActivityTest
{
  private static final String STRING_TO_BE_TYPED = "Peter";

  //@Rule ActivityTestRule 指明被测试的 Activity
  @Rule
  public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

  @Before
  public void setUp() throws Exception
  {

  }

  @Test
  public void testSayHello() throws Exception
  {
    onView(withId(R.id.et_name)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
    onView(withText("Say Hello!")).perform(click());
    String expect = "Hello," + STRING_TO_BE_TYPED;
    onView(withId(R.id.tv_name)).check(matches(withText(expect)));
  }

  @Test
  public void testShowTestFragment() throws Exception
  {
    //获取 Fragment 中的 text
    ViewInteraction fragmentText = onView(withId(R.id.tv_test_fragment));
    //验证 text 不存在
    fragmentText.check(doesNotExist());
    //点击按钮显示 fragment
    onView(withId(R.id.btn_show_test_fragment)).perform(click());
    //验证 text 已加载显示
    fragmentText.check(matches(isDisplayed()));
  }
}