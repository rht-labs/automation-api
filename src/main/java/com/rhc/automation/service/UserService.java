package com.rhc.automation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;

/**
 * A service for users and roles
 * @author kmcanoy
 *
 */
public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    User getUser(Long userId);
    Page<User> getUsers(Pageable pager);
    
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long roleId);
    Page<Role> getRoles(Pageable pager);
    Role getRole(Long roleId);
    
    void addRoleMapping(RoleMapping roleMapping);
    void updateRoleMapping(RoleMapping roleMapping);
    void deleteRoleMapping(Long roleMappingId);
    Page<RoleMapping> getRoleMappings(Pageable pager);
    RoleMapping getRoleMapping(Long roleId);
    
}
