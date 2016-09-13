package com.rhc.automation.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.User;

@Component("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final UserRespository userRepository;
    private final RoleRepository roleRepository;
    
    public CustomerServiceImpl(UserRespository userRespository, RoleRepository roleRepository) {
        this.userRepository = userRespository;
        this.roleRepository = roleRepository;
    }
    
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
    

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
        
    }

    @Override
    public void updateUser(User user) {
        User current = userRepository.findOne(user.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("User with id %d, not found", user.getId()));
        }
        
        current.setEmail(user.getEmail());
        current.setFirstName(user.getFirstName());
        current.setLastName(user.getLastName());

        userRepository.save(current);
        
    }
    
    @Override
    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }
    
    @Override
    public Page<User> getUsers(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }




  
}
