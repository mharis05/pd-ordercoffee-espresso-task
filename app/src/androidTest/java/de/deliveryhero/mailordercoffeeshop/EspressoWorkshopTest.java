package de.deliveryhero.mailordercoffeeshop;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testTaskOne() {
        onView(withId(R.id.close_button)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withId(R.id.milk_type)).perform(click());
        onData(is("Low fat")).perform(click());

        onView(allOf(withText("Steamed"),
                withParent(withId(R.id.radio_group)))).perform(click())
                .check(matches(isChecked()));

        onView(withId(R.id.review_order_button)).perform(scrollTo()).perform(click());
        onView(withId(R.id.name_text_box)).perform(typeText("Haris"), closeSoftKeyboard());
        onView(withId(R.id.email_text_box)).perform(typeText("haris@test.com"), closeSoftKeyboard());
        onView(withId(R.id.custom_order_name_box)).perform(typeText("damndaniel"), closeSoftKeyboard());
        onView(withId(R.id.mail_order_button)).perform(click());

    }

}
