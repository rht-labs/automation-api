package com.rhc.automation.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.User;

public class UserServiceTest {

    @Mock
    private UserRespository userRepository;
    
    @InjectMocks
    private UserServiceImpl userService;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        Mockito.when(userRepository.findOne(1L)).thenReturn(new User());
    }
    
    @Test
    public void testUpdateUserLegit() {
        User user = new User();
        user.setId(1L);
        
        userService.updateUser(user);
    }
    
    @Test(expected = NotFoundException.class)
    public void testUpdateUserDoesNotExist() {
        
        User user = new User();
        user.setId(2L);
        
        try {
            userService.updateUser(user);
        } catch (NotFoundException nfe) {
            Assert.assertEquals("User with id 2 not found", nfe.getMessage());
            throw nfe;
        }
    }
}
