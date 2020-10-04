package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetsActivityTest {


    @Rule
    public ActivityTestRule<SetsActivity> setsActivityActivityTestRule = new ActivityTestRule<SetsActivity>(SetsActivity.class);
    private SetsActivity setsActivity = null;


    @Before
    public void setUp() throws Exception {

        setsActivity = setsActivityActivityTestRule.getActivity();


    }

    @Test
    public void test()
    {
        View view = setsActivity.findViewById(R.id.set_toolbar);
        assertNotNull(view);


    }

    @After
    public void tearDown() throws Exception {

        setsActivity = null;
    }
}