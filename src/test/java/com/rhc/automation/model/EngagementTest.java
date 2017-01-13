package com.rhc.automation.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EngagementTest {

    @Test
    public void shouldBeAValidEngagement() {
        // given
        Engagement e = new Engagement();
        e.setId(1l);
        e.setName("test engagement");

        // when
        boolean isValid = e.determineIfValid();

        // then
        Assert.assertTrue(isValid);
    }

    @Test
    public void shouldBeAValidEngagementForMissingId() {
        // given
        Engagement e = new Engagement();
        e.setName("test engagement");

        // when
        boolean isValid = e.determineIfValid();
        List<String> invalidFields = e.determineInvalidFields();

        // then
        Assert.assertFalse(isValid);
        Assert.assertEquals(1, invalidFields.size());
        Assert.assertTrue(invalidFields.contains("id"));
    }

    @Test
    public void shouldBeAValidEngagementForEmptyName() {
        // given
        Engagement e = new Engagement();
        e.setId(1l);
        e.setName("");

        // when
        boolean isValid = e.determineIfValid();
        List<String> invalidFields = e.determineInvalidFields();

        // then
        Assert.assertFalse(isValid);
        Assert.assertEquals(1, invalidFields.size());
        Assert.assertTrue(invalidFields.contains("name"));
    }

    @Test
    public void shouldBeAValidEngagementForMissingName() {
        // given
        Engagement e = new Engagement();
        e.setId(1l);
        e.setName("");

        // when
        boolean isValid = e.determineIfValid();
        List<String> invalidFields = e.determineInvalidFields();

        // then
        Assert.assertFalse(isValid);
        Assert.assertEquals(1, invalidFields.size());
        Assert.assertTrue(invalidFields.contains("name"));
    }

}
