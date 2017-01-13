package com.rhc.automation.service;

import com.rhc.automation.exception.DuplicateEngagementIdsException;
import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.EngagementSummary;
import com.rhc.automation.utils.ObjectMother;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EngagementServiceTest {

    EngagementService engagementService = new EngagementService();


    @Test
    public void shouldReturnAllEngagementsWithSearchTermInTheirName() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementService.addEngagement( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementService.addEngagement( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "do not find me" );
        engagementService.addEngagement( e3 );

        String searchTerm = "CUSTOMER";

        // when
        List<Engagement> engagementList = engagementService.engagementList( searchTerm );

        // then
        Assert.assertEquals( 2, engagementList.size() );
        for ( Engagement e : engagementList ) {
            Assert.assertTrue( e.nameContainsSearchTerm( searchTerm ) );
        }
    }

    @Test
    public void shouldDeleteEngagementFromList() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementService.addEngagement( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementService.addEngagement( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "delete me" );
        engagementService.addEngagement( e3 );

        Assert.assertEquals( 3, engagementService.engagementList().size() );

        // when
        Long idToDelete = e3.getId();
        try {
            engagementService.deleteEngagementById( idToDelete );
        } catch ( EngagementNotFoundException e ) {
            Assert.fail( "this exception should not be thrown" );
        }

        // then
        Assert.assertEquals( 2, engagementService.engagementList().size() );
    }

    @Test
    public void shouldAddEngagementWithSpecificId() throws InvalidEngagementException, DuplicateEngagementIdsException, EngagementNotFoundException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementService.addEngagement( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementService.addEngagement( e2 );

        Assert.assertEquals( 2, engagementService.engagementList().size() );


        // when
        Engagement e3 = ObjectMother.getBasicValidEngagement( "engagement for put" );
        Long id = e2.getId();
        engagementService.addEngagement( e3, id );

        // then
        Assert.assertEquals( 2, engagementService.engagementList().size() );
        Engagement e4 = engagementService.engagement( id );
        Assert.assertEquals( "engagement for put", e4.getName() );
    }

    @Test
    public void shouldNotCreateDuplicateIds() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementService.addEngagement( e1, 1l );

        Engagement e2 = ObjectMother.getBasicValidEngagement( " customer 2" );
        engagementService.addEngagement( e2 );


        // when
        Engagement e3 = ObjectMother.getBasicValidEngagement( " customer 3" );
        engagementService.addEngagement( e3 );

        // then
        List<Engagement> engagementList = engagementService.engagementList();
        Assert.assertEquals( 3, engagementList.size() );
        Assert.assertEquals( new Long( 1 ), engagementList.get( 0 ).getId() );
        Assert.assertEquals( new Long( 0 ), engagementList.get( 1 ).getId() );
        Assert.assertEquals( new Long( 2 ), engagementList.get( 2 ).getId() );
    }


}
