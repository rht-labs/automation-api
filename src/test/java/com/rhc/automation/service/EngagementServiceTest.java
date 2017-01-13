package com.rhc.automation.service;

import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.utils.ObjectMother;
import org.junit.Assert;
import org.junit.Test;

public class EngagementServiceTest {

    EngagementService engagementService = new EngagementService();

    @Test
    public void shouldAddNewValidEngagement() throws InvalidEngagementException {
        // given
        Engagement engagement = ObjectMother.getBasicValidEngagement();
        Assert.assertEquals(new Integer(0), engagementService.getNumberOfEngagements());

        // when
        engagementService.addEngagement(engagement);

        // then
        Assert.assertEquals(new Integer(1), engagementService.getNumberOfEngagements());
        Engagement returnedEngagement = engagementService.getEngagementList().get(0);
        Assert.assertNotNull(returnedEngagement);
        Assert.assertTrue(returnedEngagement.determineIfValid());
    }

    @Test
    public void shouldNotAddNewInvalidEngagements() {
        // given
        Engagement engagement = ObjectMother.getBasicInvalidEngagement();
        Assert.assertEquals(new Integer(0), engagementService.getNumberOfEngagements());

        try {
            // when
            engagementService.addEngagement(engagement);
            Assert.fail("exception should be thrown before this point");
        } catch (InvalidEngagementException e) {
            // then
            Assert.assertEquals(new Integer(0), engagementService.getNumberOfEngagements());
        }
    }
}
