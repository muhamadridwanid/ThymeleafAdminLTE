/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.models;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

/**
 *
 * @author mridwan
 */
@Entity
public class Jabatan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @JsonView(DataTablesOutput.View.class)
    private String name;

    public Jabatan() {
    }

    public Jabatan(Long id) {
        this.id = id;
    }

    public Jabatan(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
