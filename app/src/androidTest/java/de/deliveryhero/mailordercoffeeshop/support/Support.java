package de.deliveryhero.mailordercoffeeshop.support;

import androidx.test.espresso.matcher.ViewMatchers;

import de.deliveryhero.mailordercoffeeshop.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class Support {
    public static void addEspressoShot(int times) {
        for(int i = 1; i <= times; i++)
            onView(ViewMatchers.withId(R.id.more_espresso)).perform(click());
    }
}
