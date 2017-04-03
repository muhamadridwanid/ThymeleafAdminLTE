/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.services.impl;

import id.muhamadridwan.starter.services.RoleService;
import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.repositories.RoleRepository;
import id.muhamadridwan.starter.utils.Util;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mridwan
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) throws NullPointerException {
        if (Util.isNotNull(role)) {
            LOG.info("Add role : " + role.getName());
            roleRepository.save(role);
        }
    }

    @Override
    public void updateRole(Role role) throws NullPointerException, EntityNotFoundException {
        if (Util.isNotNull(role) || Util.isNotNull(role.getId())) {
            LOG.info("Update role : " + role.getName());
            Role updateRole = roleRepository.findOne(role.getId());
            updateRole.setName(role.getName());
            roleRepository.save(updateRole);
        }
    }

    @Override
    public void deleteRole(Long id) throws NullPointerException, EntityNotFoundException {
        if (Util.isNotNull(id)) {
            Role deleteRole = roleRepository.getOne(id);
            LOG.info("Delete role : " + deleteRole.getName());
            roleRepository.delete(deleteRole);
        }
    }

    @Override
    public Role getRole(Long id) throws NullPointerException, EntityNotFoundException {
        LOG.info("Get role by id : " + id);
        Role role = null;
        if (Util.isNotNull(role)) {
            role = roleRepository.findOne(id);            
        }
        return role;
    }

    @Override
    public Role getRole(String roleName) throws NullPointerException, EntityNotFoundException {        
        LOG.info("Get role by name : " + roleName);
        Role role = null;
        if (Util.isNotNull(roleName)) {
            role = roleRepository.findByName(roleName);
        }        
        return role;       
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
