package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdQuestionDetailsActivityTest {


    @Rule
    public ActivityTestRule<AdQuestionDetailsActivity> adQuestionDetailsActivityActivityTestRule = new ActivityTestRule<AdQuestionDetailsActivity>(AdQuestionDetailsActivity.class);
    private AdQuestionDetailsActivity adQuestionDetailsActivity = null;


    @Before
    public void setUp() throws Exception {

        adQuestionDetailsActivity = adQuestionDetailsActivityActivityTestRule.getActivity();
    }

    @Test
    public void test()
    {
        View view = adQuestionDetailsActivity.findViewById(R.id.question);
        assertNotNull(view);


    }

    @After
    public void tearDown() throws Exception {

        adQuestionDetailsActivity = null;

    }
}