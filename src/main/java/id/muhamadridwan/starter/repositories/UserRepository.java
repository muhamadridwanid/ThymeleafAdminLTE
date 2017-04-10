/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.repositories;

import id.muhamadridwan.starter.models.User;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mridwan
 */
@Repository
public interface UserRepository extends DataTablesRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
    
    
}
