/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author mridwan
 */
@Entity
public class Role implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String authority;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }
    
    public Role(String name) {
        this.authority = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    //<editor-fold defaultstate="collapsed" desc="SETTER">
    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
//</editor-fold>

}
