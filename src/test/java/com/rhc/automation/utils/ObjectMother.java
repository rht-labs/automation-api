package com.rhc.automation.utils;

import com.rhc.automation.model.Engagement;

import java.util.Random;

public class ObjectMother {

    public static Engagement getBasicValidEngagement( String name ) {
        Engagement engagement = new Engagement();
        engagement.setName( name );
        return engagement;
    }

    public static Engagement getBasicValidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setName( "basic valid engagement" );
        return engagement;
    }

    public static Engagement getBasicInvalidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setName( "basic invalid engagement: no ID" );
        return engagement;
    }

}
