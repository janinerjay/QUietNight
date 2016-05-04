package com.example.christiandegenova.quietnight_1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * ApplicationTest.java
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    //Create the Splash Activity to start the tests with
    @Rule
    public ActivityTestRule<SplashActivity> mActivityRule = new ActivityTestRule<>(
            SplashActivity.class);

    //Create a test for the action bar
    @Test
    public void MenuTest() throws InterruptedException {

        //Click on brighten option
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
        openContextualActionModeOverflowMenu();
        onView(withText("Brighten/Dim")).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on About Us option
        openContextualActionModeOverflowMenu();
        onView(withText("About QUietNight")).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
    }

    //Create a test for the sports feature
    @Test
    public void SportsTest() throws InterruptedException {
        //Click on main menu
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
        onView(withId(R.id.menu_button)).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on sports button
        onView(withId(R.id.sport_button)).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on item in sports view
        onView(withId(R.id.mHock)).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on sport game
        onView(withText("02-20-16")).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
    }

    //Create a test for the hot spots feature
    @Test
    public void HotTest() throws InterruptedException {

        //Click on main menu
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
        onView(withId(R.id.menu_button)).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on hot spot activity
        onView(withId(R.id.hot_button)).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}

        //Click on hot spot
        onView(withText("Box 63")).perform(click());
        try {
            synchronized (this) {wait(1500);}
        } catch (InterruptedException ex) {}
    }
}