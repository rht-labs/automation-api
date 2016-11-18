package com.rhc.automation.service;



import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.Group;
import com.rhc.automation.model.GroupRoleMapping;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRespository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final GroupRepository groupRepository;
    private final GroupRoleMappingRepository groupRoleRepository;
    
    public UserServiceImpl(UserRespository userRespository, RoleRepository roleRepository,
            UserRoleRepository userRoleRepository, GroupRoleMappingRepository groupRoleRepository,
            GroupRepository groupRepository) {
        this.userRepository = userRespository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.groupRoleRepository = groupRoleRepository;
        this.groupRepository = groupRepository;
    }
    
    @Override
    public void addUser(User user) {
        Example<User> ex = Example.of(user);
        User foundUser = userRepository.findOne(ex);
        
        if(foundUser != null) {
            user.setId(foundUser.getId());
        } else {
            userRepository.save(user);
        }
    }
    

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
        
    }

    @Override
    public void updateUser(User user) {
        User current = userRepository.findOne(user.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("User with id %d not found", user.getId()));
        }

        userRepository.save(user);
        
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
        Example<Role> ex = Example.of(role);
        Role foundRole = roleRepository.findOne(ex);
        
        if(foundRole != null) {
            role.setId(foundRole.getId());
        } else {
            roleRepository.save(role);
        }
        
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
        User user = roleMapping.getUser();
        if(user != null && (user.getId() == null || user.getId() == 0)) {
            user.setId(null);
            addUser(user);
        }
        
        for(Role role : roleMapping.getRoles()) {
            if(role.getId() == null || role.getId() == 0) {
                addRole(role);
            }
        }
        
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

    @Override
    public void addGroup(Group group) {
        Example<Group> ex = Example.of(group);
        Group foundGroup = groupRepository.findOne(ex);
        
        for(User user : group.getMembers()) {
            addUser(user); //addUser will check for existence and add if necessary
        }
        
        if(foundGroup == null) {
            groupRepository.save(group);
        } else {
            group.setId(foundGroup.getId());
        }
        
    }

    @Override
    public void updateGroup(Group group) {
        Group current = groupRepository.findOne(group.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Group with id %d not found", group.getId()));
        }

        groupRepository.save(group);
        
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupRepository.delete(groupId);
        
    }

    @Override
    public Page<Group> getGroups(Pageable pager) {
        return groupRepository.findAll(pager);
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findOne(groupId);
    }

    @Override
    public void addGroupMapping(GroupRoleMapping groupRoleMapping) {
        Group group = groupRoleMapping.getGroup();
        
        if(group != null && (group.getId() == null || group.getId() == 0)) {
            group.setId(null);
            addGroup(group);
        }
        
        for(Role role : groupRoleMapping.getRoles()) {
            if(role.getId() == null || role.getId() == 0) {
                role.setId(null);
                addRole(role);
            }
        }
        groupRoleRepository.save(groupRoleMapping);
        
    }

    @Override
    public void updateGroupMapping(GroupRoleMapping groupRoleMapping) {
        GroupRoleMapping current = groupRoleRepository.findOne(groupRoleMapping.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Group Role with id %d not found", groupRoleMapping.getId()));
        }
        
    }

    @Override
    public void deleteGroupMapping(Long groupRoleMappingId) {
        groupRoleRepository.delete(groupRoleMappingId);
        
    }

    @Override
    public Page<GroupRoleMapping> getGroupRoleMappings(Pageable pager) {
        return groupRoleRepository.findAll(pager);
    }

    @Override
    public GroupRoleMapping getGroupRoleMapping(Long groupRoleId) {
        return groupRoleRepository.findOne(groupRoleId);
    }




  
}
