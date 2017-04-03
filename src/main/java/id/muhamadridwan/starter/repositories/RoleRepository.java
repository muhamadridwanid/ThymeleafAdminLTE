/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.repositories;

import id.muhamadridwan.starter.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mridwan
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String user);
    
}
