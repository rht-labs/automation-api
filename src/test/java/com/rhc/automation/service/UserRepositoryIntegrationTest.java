package com.rhc.automation.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.rhc.automation.model.User;

public class UserRepositoryIntegrationTest extends BaseIntegrationTest {
    org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRepositoryIntegrationTest.class);

    private String[] userNabors = { "jim@nabors.com", "jimnam", "Jim", "Nabors" };
    
    
    
    @Autowired
    private UserRespository userRepository;
    
    @Test 
    public void saveUserEmailRequired() throws Exception {

        User user = new User();
        user.setEmail(null);
        user.setUserName(userNabors[1]);
        user.setFirstName(userNabors[2]);
        user.setLastName(userNabors[3]);
        
        try {
            userRepository.save(user);
            Assert.fail("A data integrity violation should have occurred");
        } catch (DataIntegrityViolationException dive) {
            Assert.assertTrue(dive.getMessage().startsWith("could not"));
        }
        
        Assert.assertNull(user.getId());
        
    }
    
    @Test 
    public void saveUserUserNameRequired() throws Exception {;

        User user = new User();
        user.setEmail(userNabors[0]);
        user.setUserName(null);
        user.setFirstName(userNabors[2]);
        user.setLastName(userNabors[3]);
        
        try {
            userRepository.save(user);
            Assert.fail("A data integrity violation should have occurred");
        } catch (DataIntegrityViolationException dive) {
            Assert.assertTrue(dive.getMessage().startsWith("could not"));
        }
        
        Assert.assertNull(user.getId());
        
    }
    
    @Test 
    public void saveUserLegit() throws Exception {
        String[] userLegit = { "sterling@archer.com", "worldsgreatestspy", "Sterling", "Archer" };
       
        User user = new User();
        user.setEmail(userLegit[0]);
        user.setUserName(userLegit[1]);
        user.setFirstName(userLegit[2]);
        user.setLastName(userLegit[3]);
        
        userRepository.save(user);
        
        Assert.assertNotNull(user.getId());
        
    }
    
    @Test
    public void findUserByIdShouldReturnUser() {
        String[] userData = { "jose@bautista.com", "joeybats19", "Jose", "Bautista" };
        User user = new User();
        user.setEmail(userData[0]);
        user.setUserName(userData[1]);
        user.setFirstName(userData[2]);
        user.setLastName(userData[3]);
        getTestEntityManager().persist(user);
        
        User find = userRepository.findOne(user.getId());
        
        Assert.assertNotNull("User not found", find);
        Assert.assertEquals(userData[0], user.getEmail());
        Assert.assertEquals(userData[1], user.getUserName());
        Assert.assertEquals(userData[2], user.getFirstName());
        Assert.assertEquals(userData[3], user.getLastName());
    }
    
    @Test
    public void findUsersWithPage() {
        String[] userData = { "edwin@encarnacion.com", "theparrot", "Edwin", "Encarnacion" };
        User user = new User();
        user.setEmail(userData[0]);
        user.setUserName(userData[1]);
        user.setFirstName(userData[2]);
        user.setLastName(userData[3]);
        getTestEntityManager().persist(user);
        
        PageRequest pageRequest = new PageRequest(0, 100);
        
        Page<User> userPage = userRepository.findAll(pageRequest);
        
        Assert.assertTrue(userPage.getContent().size() > 0);
    }
}
