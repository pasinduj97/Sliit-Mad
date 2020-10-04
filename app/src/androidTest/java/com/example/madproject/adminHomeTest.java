package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class adminHomeTest {



    @Rule
    public ActivityTestRule<adminHome> adminHomeActivityTestRule = new ActivityTestRule<adminHome>(adminHome.class);
    private adminHome adminHome = null;



    @Before
    public void setUp() throws Exception {

        adminHome = adminHomeActivityTestRule.getActivity();
    }

    @Test
    public void test()
    {
        View view = adminHome.findViewById(R.id.imageView10);
        assertNotNull(view);


    }


    @After
    public void tearDown() throws Exception {

        adminHome = null;

    }
}