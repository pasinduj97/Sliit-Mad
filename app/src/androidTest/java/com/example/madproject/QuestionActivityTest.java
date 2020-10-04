package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionActivityTest {

    @Rule
    public ActivityTestRule<QuestionActivity> questionActivityActivityTestRule = new ActivityTestRule<QuestionActivity>(QuestionActivity.class);
    private QuestionActivity questionActivity = null;


    @Before
    public void setUp() throws Exception {

        questionActivity = questionActivityActivityTestRule.getActivity();


    }

    @Test
    public void test()
    {
        View view = questionActivity.findViewById(R.id.question);
        assertNotNull(view);


    }


    @After
    public void tearDown() throws Exception {

        questionActivity = null;

    }
}