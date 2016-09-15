package com.rhc.automation.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;

@Component("customerService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRespository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    
    public UserServiceImpl(UserRespository userRespository, RoleRepository roleRepository,
            UserRoleRepository userRoleRepository) {
        this.userRepository = userRespository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
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
    public Page<User> getUsers(Pageable pager) {
        return userRepository.findAll(pager);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
        
    }
    
    @Override
    public void updateRole(Role role) {
        Role current = roleRepository.findOne(role.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Role with id %d, not found", role.getId()));
        }
        
        current.setName(role.getName());
        
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.delete(roleId);
        
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Page<Role> getRoles(Pageable pager) {
        return roleRepository.findAll(pager);
    }

    @Override
    public void addRoleMapping(RoleMapping roleMapping) {
        userRoleRepository.save(roleMapping);
        
    }

    @Override
    public void updateRoleMapping(RoleMapping roleMapping) {
        RoleMapping current = userRoleRepository.findOne(roleMapping.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("RoleMapping with id %d not found", roleMapping.getId()));
        }
        
        current.setUser(roleMapping.getUser());
        current.setRoles(roleMapping.getRoles());
        
        userRoleRepository.save(roleMapping);
    }

    @Override
    public void deleteRoleMapping(Long roleMappingId) {
        userRoleRepository.delete(roleMappingId);
        
    }

    @Override
    public Page<RoleMapping> getRoleMappings(Pageable pager) {
        return userRoleRepository.findAll(pager);
    }

    @Override
    public RoleMapping getRoleMapping(Long roleId) {
        return userRoleRepository.findOne(roleId);
    }




  
}
