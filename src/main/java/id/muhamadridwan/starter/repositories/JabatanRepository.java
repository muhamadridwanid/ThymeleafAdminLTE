/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.repositories;

import id.muhamadridwan.starter.models.Jabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mridwan
 */
@Repository
public interface JabatanRepository extends JpaRepository<Jabatan, Long> {

    Jabatan findByName(String user);
    
}