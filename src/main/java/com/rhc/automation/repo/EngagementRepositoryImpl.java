package com.rhc.automation.repo;

import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EngagementRepositoryImpl implements EngagementRepository {

    @Autowired
    private EngagementSpringDataRepository db;

    @Override
    public void save( Engagement engagement ) throws InvalidEngagementException {
        Engagement savedEngagement = db.save( engagement );

        // roll transaction back if not invariants not met by throwing exception
        if ( !savedEngagement.determineIfValid() ) {
            throw new InvalidEngagementException( engagement.determineInvalidFields() );
        }
    }

    @Override
    public boolean save( Engagement engagement, Long id ) throws InvalidEngagementException {
        boolean newEngagementCreated = true;
        if ( db.exists( id ) ){
            newEngagementCreated = false;
        }
        engagement.setId( id );
        save(engagement);
        return newEngagementCreated;
    }

    @Override
    public void delete( Long id ) throws EngagementNotFoundException {
        if ( db.exists( id ) ) {
            db.delete( id );
        } else {
            throw new EngagementNotFoundException( id );
        }
    }

    @Override
    public void deleteAll() {
        db.deleteAll();
    }

    @Override
    public Long count() {
        return db.count();
    }

    // TODO this should be paged
    @Override
    public List<Engagement> getAll() {
        List<Engagement> engagements = new ArrayList<>();
        Iterator<Engagement> it = db.findAll().iterator();
        while ( it.hasNext() ){
            engagements.add( it.next() );
        }
        return engagements;
    }

    // TODO this should be paged
    @Override
    public List<Engagement> findByNameContainingIgnoreCase( String nameSearchTerm ) {
        return db.findByNameContainingIgnoreCase( nameSearchTerm );
    }

    @Override
    public List<Engagement> findByNameContainingIgnoreCase( String nameSearchTerm, Integer size, Long offset ) {
        throw new NotImplementedException();
    }

    @Override
    public Engagement findById( Long id ) throws EngagementNotFoundException {
        if ( db.exists( id ) ){
            return db.findOne( id );
        } else {
            throw new EngagementNotFoundException( id );
        }

    }
}
