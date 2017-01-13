package com.rhc.automation.service;

import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.EngagementSummary;
import com.rhc.automation.utils.ObjectMother;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EngagementSummaryServiceTest {

    EngagementService engagementService = new EngagementService();
    EngagementSummaryService engagementSummaryService = new EngagementSummaryService( engagementService );

    @Test
    public void shouldReturnAllEngagementSummariesWithSearchTermInTheirName() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementService.addEngagement( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementService.addEngagement( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "do not find me" );
        engagementService.addEngagement( e3 );

        String searchTerm = "CUSTOMER";

        // when
        List<EngagementSummary> engagementSummariesList = engagementSummaryService.engagementSummariesList( searchTerm );

        // then
        Assert.assertEquals( 2, engagementSummariesList.size() );
        for ( EngagementSummary e : engagementSummariesList ) {
            Assert.assertTrue( e.nameContainsSearchTerm( searchTerm ) );
        }
    }
}
