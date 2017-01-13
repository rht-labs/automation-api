package com.rhc.automation.utils;

import com.rhc.automation.model.Engagement;

import java.util.Random;

public class ObjectMother {

    public static Random random = new Random(System.currentTimeMillis());

    public static Engagement getBasicValidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setId(new Long(random.nextLong()));
        engagement.setName("basic valid engagement");
        return engagement;
    }

    public static Engagement getBasicInvalidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setName("basic invalid engagement: no ID");
        return engagement;
    }
}
