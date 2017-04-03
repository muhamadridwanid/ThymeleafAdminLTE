/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.services;

import id.muhamadridwan.starter.models.Role;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author mridwan
 */
public interface RoleService {

    void addRole(Role role) throws NullPointerException;

    void updateRole(Role role) throws NullPointerException, EntityNotFoundException;

    void deleteRole(Long id) throws NullPointerException, EntityNotFoundException;

    Role getRole(Long id) throws NullPointerException, EntityNotFoundException;

    Role getRole(String roleName) throws NullPointerException, EntityNotFoundException;

    List<Role> getRoles();

}
