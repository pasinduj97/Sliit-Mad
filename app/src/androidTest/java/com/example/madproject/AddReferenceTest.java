package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddReferenceTest {


    @Rule
    public ActivityTestRule<AddReference> AddReferenceActivityTestRule = new ActivityTestRule<AddReference>(AddReference.class);
    private AddReference AddReference = null;

    @Before
    public void setUp() throws Exception {

        AddReference = AddReferenceActivityTestRule.getActivity();
    }

    @Test
    public void test()
    {
        View view = AddReference.findViewById(R.id.textView5);
        assertNotNull(view);


    }


    @After
    public void tearDown() throws Exception {
        AddReference = null;
    }
}