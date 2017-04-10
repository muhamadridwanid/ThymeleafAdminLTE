/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.models;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author mridwan
 */
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(DataTablesOutput.View.class)
    @Column(unique = true)
    private String username;

    private String password;

    @JsonView(DataTablesOutput.View.class)
    private String nama;

    private String alamat;

    @JsonView(DataTablesOutput.View.class)
    private String noHp;

    @JsonView(DataTablesOutput.View.class)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessedDate;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private Collection<Role> authorities;

    @JsonView(DataTablesOutput.View.class)
    @ManyToOne
    private Jabatan jabatan;

    //<editor-fold defaultstate="collapsed" desc="Constructor dll">
    //Constructor
    public User() {
    }

    public User(String username, String nama, String email, Jabatan jabatan) {
        this.username = username;
        this.nama = nama;
        this.email = email;
        this.jabatan = jabatan;
    }
    
    public User(String username, String nama, String email, Collection<Role> authorities, Jabatan jabatan) {
        this.username = username;
        this.nama = nama;
        this.email = email;
        this.authorities = authorities;
        this.jabatan = jabatan;
    }

    public User(String username, String nama, String email, Long idRole, Long idJabatan) {
        this.username = username;
        this.nama = nama;
        this.email = email;
        Role role = new Role(idRole);
        this.authorities = new HashSet<>();
        authorities.add(role);
        this.jabatan = new Jabatan(idJabatan);
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getLastAccessedDate() {
        return lastAccessedDate;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nama=" + nama + ", "
                + "alamat=" + alamat + ", noHp=" + noHp + ", email=" + email + ", createdAt=" + createdAt + ", "
                + "updatedAt=" + updatedAt + ", lastAccessedDate=" + lastAccessedDate + ", accountNonExpired="
                + accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired="
                + credentialsNonExpired + ", enabled=" + enabled + '}';
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastAccessedDate(Date lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public void setAuthorities(Collection<Role> authorities) {
        this.authorities = authorities;
    }

    public void setAuthority(Role authority) {
        Set<Role> authoritys = new HashSet<>();
        authoritys.add(authority);
        this.authorities = authoritys;
    }
//</editor-fold>

}
