package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManageCategoriesTest {

    @Rule
    public ActivityTestRule<ManageCategories> manageCategoriesActivityTestRule = new ActivityTestRule<ManageCategories>(ManageCategories.class);
    private ManageCategories manageCategories = null;

    @Before
    public void setUp() throws Exception {

        manageCategories = manageCategoriesActivityTestRule.getActivity();

    }

    @Test
    public void test()
    {
        View view = manageCategories.findViewById(R.id.addCatB);
        assertNotNull(view);


    }

    @After
    public void tearDown() throws Exception {
        manageCategories = null;
    }
}