/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.validators;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author mridwan
 */
public class CreateUserForm {

    @Size(min = 6, message = "Username kurang dari 6 karakter")
    String username;

    @NotEmpty(message = "Nama tidak boleh kosong")
    String nama;

    @NotEmpty(message = "Email tidak boleh kosong")
    @Email(message = "Format Email Salah")
    String email;
    
    Long roleId;
    Long jabatanId;

    public CreateUserForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getJabatanId() {
        return jabatanId;
    }

    public void setJabatanId(Long jabatanId) {
        this.jabatanId = jabatanId;
    }

    @Override
    public String toString() {
        return "CreateValidator{" + "username=" + username + ", nama=" + nama + ", email=" + email + ", roleId=" + roleId + ", jabatanId=" + jabatanId + '}';
    }

}
