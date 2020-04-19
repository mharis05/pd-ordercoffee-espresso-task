package de.deliveryhero.mailordercoffeeshop;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import de.deliveryhero.mailordercoffeeshop.support.Support;
import de.deliveryhero.mailordercoffeeshop.support.TestData;

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
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testFixedData() {
        // Generate Test data
        TestData testData = new TestData();
        // Save expected test data for validation
        Integer espressoShots = testData.getEspressoShotCount();
        Boolean isChocolate = false;
        String milkType = testData.milkSelectionObject.LOWFAT;
        String milkTreatment = testData.milkTreatmentObject.STEAMED;

        // UI Actions
        onView(withId(R.id.close_button)).perform(click());
        Support.addEspressoShot(espressoShots);
        // Validate that espresso shots match as the number of times button was clicked
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText(espressoShots.toString())));

        // Include chocolate
        onView(withId(R.id.chocolate)).perform(click());

        // Select milk type
        onView(withId(R.id.milk_type)).perform(click());
        onData(is(milkType)).perform(click());

        // Select Steamed milk
        onView(allOf(withText(milkTreatment),
                withParent(withId(R.id.radio_group)))).perform(click())
                .check(matches(isChecked()));

        // Add order for confirmation
        onView(withId(R.id.review_order_button)).perform(scrollTo()).perform(click());

        // Validations
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withSubstring(espressoShots.toString())));
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withSubstring(milkType)));
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withSubstring(milkTreatment)));
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withSubstring("Chocolate")));

        // Fill in the user data form
        onView(withId(R.id.name_text_box)).perform(typeText(testData.getUserData().getUserName()), closeSoftKeyboard());
        onView(withId(R.id.email_text_box)).perform(typeText(testData.getUserData().getUserEmail()), closeSoftKeyboard());
        onView(withId(R.id.custom_order_name_box)).perform(typeText(testData.getUserData().getUserAlias()), closeSoftKeyboard());
        onView(withId(R.id.mail_order_button)).perform(click());

    }

}
