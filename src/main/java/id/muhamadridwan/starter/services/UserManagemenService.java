/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.services;

import id.muhamadridwan.starter.models.Jabatan;
import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import java.util.List;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author mridwan
 */
public interface UserManagemenService extends UserDetailsService {

    //User
    User getUser(Long userId);

    User getUser(String username);

    void addUser(User user);

    void updateUser(User user);
    
    void updateProfile(User user);

    void changePassword(String passLama, String passBaru);

    void deleteUser(Long userId);

    //Jabatan

    void addJabatan(Jabatan jabatan);

    void updateJabatan(Jabatan jabatan);

    void deleteJabatan(Long id);

    Jabatan getJabatan(Long id);

    Jabatan getJabatan(String jabatanName);

    List<Jabatan> getJabatans();

    //Role
    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    Role getRole(Long id);

    Role getRole(String roleName);

    List<Role> getRoles();
    
    //Datatable
    DataTablesOutput<User> getDataTablesOutput(DataTablesInput input);
    Iterable<User> getUsers();

}
