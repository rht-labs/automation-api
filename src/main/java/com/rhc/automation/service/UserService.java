package com.rhc.automation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhc.automation.model.Group;
import com.rhc.automation.model.GroupRoleMapping;
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
    
    void addGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(Long groupId);
    Page<Group> getGroups(Pageable pager);
    Group getGroup(Long groupId);
    
    void addGroupMapping(GroupRoleMapping groupRoleMapping);
    void updateGroupMapping(GroupRoleMapping groupRoleMapping);
    void deleteGroupMapping(Long groupRoleMappingId);
    Page<GroupRoleMapping> getGroupRoleMappings(Pageable pager);
    GroupRoleMapping getGroupRoleMapping(Long groupRoleId);
    
}
