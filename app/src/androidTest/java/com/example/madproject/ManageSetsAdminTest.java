package com.example.madproject;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManageSetsAdminTest {

    @Rule
    public ActivityTestRule<ManageSetsAdmin> manageSetsAdminActivityTestRule = new ActivityTestRule<ManageSetsAdmin>(ManageSetsAdmin.class);
    private ManageSetsAdmin manageSetsAdmin = null;

    @Before
    public void setUp() throws Exception {

        manageSetsAdmin = manageSetsAdminActivityTestRule.getActivity();
    }

    @Test
    public void test()
    {
        View view = manageSetsAdmin.findViewById(R.id.sets_recycler);
        assertNotNull(view);


    }


    @After
    public void tearDown() throws Exception {
        manageSetsAdmin = null;
    }
}