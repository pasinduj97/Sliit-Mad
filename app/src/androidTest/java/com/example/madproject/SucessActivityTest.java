package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SucessActivityTest {

    @Rule
    public ActivityTestRule<SucessActivity> sucessActivityActivityTestRule = new ActivityTestRule<SucessActivity>(SucessActivity.class);
    private SucessActivity sucessActivity = null;


    @Before
    public void setUp() throws Exception {

        sucessActivity = sucessActivityActivityTestRule.getActivity();

    }


    @Test
    public void test()
    {
        View view = sucessActivity.findViewById(R.id.imageView3);
        assertNotNull(view);


    }

    @After
    public void tearDown() throws Exception {

        sucessActivity = null;
    }
}