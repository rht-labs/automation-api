package com.rhc.automation.repo;

import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.utils.ObjectMother;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class EngagementRepositoryIT extends BaseIntegrationTst {

    @Test
    public void shouldReturnAllEngagementsWithSearchTermInTheirName() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementRepository.save( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementRepository.save( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "do not find me" );
        engagementRepository.save( e3 );

        String searchTerm = "CUSTOMER";

        // when
        List<Engagement> engagementList = engagementRepository.findByNameContainingIgnoreCase( searchTerm );

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
        engagementRepository.save( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementRepository.save( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "delete me" );
        engagementRepository.save( e3 );

        Assert.assertEquals( new Long( 3l ), engagementRepository.count() );

        // when
        Long idToDelete = e3.getId();
        try {
            engagementRepository.delete( idToDelete );
        } catch ( EngagementNotFoundException e ) {
            Assert.fail( "this exception should not be thrown" );
        }

        // then
        Assert.assertEquals( new Long( 2l ), engagementRepository.count() );
    }

    @Test
    public void shouldFailToDeleteNonExistentIdFromList() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementRepository.save( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementRepository.save( e2 );

        Engagement e3 = ObjectMother.getBasicValidEngagement( "delete me" );
        engagementRepository.save( e3 );

        Assert.assertEquals( new Long( 3l ), engagementRepository.count() );

        // when
        Long idToDelete = 987654321l;
        try {
            engagementRepository.delete( idToDelete );
            Assert.fail( "an exception should be thrown before you get here" );
        } catch ( EngagementNotFoundException e ) {
            // this is expected behavior
        }

        // then
        Assert.assertEquals( new Long( 3l ), engagementRepository.count() );
    }

    @Test
    public void shouldAddEngagementWithSpecificId() throws InvalidEngagementException, EngagementNotFoundException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementRepository.save( e1 );

        Engagement e2 = ObjectMother.getBasicValidEngagement( "customer 2" );
        engagementRepository.save( e2 );

        Assert.assertEquals( new Long( 2l ), engagementRepository.count() );


        // when
        Engagement e3 = ObjectMother.getBasicValidEngagement( "findById for put" );
        Long id = e2.getId();
        engagementRepository.save( e3, id );

        // then
        Assert.assertEquals( new Long( 2l ), engagementRepository.count() );
        Engagement e4 = engagementRepository.findById( id );
        Assert.assertEquals( "findById for put", e4.getName() );
    }

    @Test
    public void shouldNotCreateDuplicateIds() throws InvalidEngagementException {
        // given
        Engagement e1 = ObjectMother.getBasicValidEngagement( " customer 1" );
        engagementRepository.save( e1, 1l );

        Engagement e2 = ObjectMother.getBasicValidEngagement( " customer 2" );
        engagementRepository.save( e2 );


        // when
        Engagement e3 = ObjectMother.getBasicValidEngagement( " customer 3" );
        engagementRepository.save( e3 );

        // then
        List<Engagement> engagementList = engagementRepository.getAll();
        Assert.assertEquals( 3, engagementList.size() );
        // ensure ids are unique
        Set<Long> ids = engagementList.stream().map( e -> e.getId() ).collect( Collectors.toSet() );
        Assert.assertEquals( 3, engagementList.size() );
    }

    @Test
    public void shouldThrowExceptionWhenFindingNonExistentId() {
        // given nothing

        try {
            // when
            Engagement notFound = engagementRepository.findById( 987654321l );
            // then fail for unexcepted behavior
            Assert.fail( "an exception should be thrown before this point" );
        } catch ( EngagementNotFoundException e ) {
            // then
            // expected behavior
        }
    }

    @Test
    public void shouldSaveRealisticEngagement() throws IOException, InvalidEngagementException {
        // given
        Engagement engagement = new ObjectMother().getEngagementFromJsonFile( "/deep_engagement.json" );

        // when
        engagementRepository.save( engagement );
        testEntityManager.flush();

        // then
        List<Engagement> searchResults = engagementRepository.findByNameContainingIgnoreCase( "deep" );
        Assert.assertEquals( 1, searchResults.size() );
    }

    @Test
    public void shouldSaveRealisticEngagementToSpecificID() throws IOException, InvalidEngagementException {
        // given
        Engagement engagement = new ObjectMother().getEngagementFromJsonFile( "/deep_engagement.json" );

        // when
        engagementRepository.save( engagement, 10l );
        testEntityManager.flush();

        // then
        try {
            Engagement searchResults = engagementRepository.findById( 10l );
            Assert.assertNotNull( searchResults );
            Assert.assertEquals( new Long(10l), searchResults.getId() );
        } catch ( EngagementNotFoundException e ) {
            Assert.fail( "did not find engagement at id 10" );
        }

    }

}
