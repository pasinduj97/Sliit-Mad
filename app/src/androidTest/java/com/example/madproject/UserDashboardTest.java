package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDashboardTest {

    @Rule
    public ActivityTestRule<UserDashboard> userDashboardActivityTestRule = new ActivityTestRule<UserDashboard>(UserDashboard.class);
    private UserDashboard userDashboard = null;

    @Before
    public void setUp() throws Exception {

        userDashboard = userDashboardActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){

        View view = userDashboard.findViewById(R.id.fullname);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        userDashboard = null;

    }
}