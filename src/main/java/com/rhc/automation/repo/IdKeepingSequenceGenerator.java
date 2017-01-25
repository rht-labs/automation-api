package com.rhc.automation.repo;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class IdKeepingSequenceGenerator extends SequenceStyleGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger( IdKeepingSequenceGenerator.class.getName() );

    @Override
    public Serializable generate( SessionImplementor session, Object object ) throws HibernateException {
        Serializable id = session.getEntityPersister( null, object ).getClassMetadata().getIdentifier( object, session );
        if ( id == null ) {
            Serializable newId = super.generate( session, object );
            LOGGER.info( String.format( "no Id found. generated Id %s for engagement", newId ) );
            return newId;
        } else {
            LOGGER.info( String.format( "using existing ID %s for engagement", id ) );
            return id;
        }
    }

}
