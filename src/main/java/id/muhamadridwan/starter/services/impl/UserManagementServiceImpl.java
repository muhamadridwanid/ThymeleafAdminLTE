/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.services.impl;

import id.muhamadridwan.starter.models.Jabatan;
import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import id.muhamadridwan.starter.repositories.JabatanRepository;
import id.muhamadridwan.starter.repositories.UserRepository;
import id.muhamadridwan.starter.utils.Util;
import java.util.Calendar;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import id.muhamadridwan.starter.services.UserManagemenService;
import java.util.List;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import id.muhamadridwan.starter.repositories.RoleRepository;

/**
 *
 * @author mridwan
 */
@Service
@Transactional
public class UserManagementServiceImpl implements UserManagemenService {

    private static final Logger LOG = LoggerFactory.getLogger(UserManagementServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JabatanRepository jabatanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUser(Long userId) {
        LOG.info("Get user by ID : " + userId);
        User user = null;
        if (Util.isNotNull(userId)) {
            user = userRepository.findOne(userId);
        }
        return user;
    }

    @Override
    public User getUser(String username) {
        LOG.info("Get user by Username : " + username);
        User user = null;
        if (Util.isNotNull(username)) {
            user = userRepository.findByUsername(username);
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        if (Util.isNotNull(user)) {
            LOG.info("Adding user : " + user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getUsername()));
            user.setCreatedAt(Calendar.getInstance().getTime());
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            userRepository.save(user);
        }
    }

    @Override
    public void updateProfile(User user) {
        if (Util.isNotNull(user) || Util.isNotNull(user.getId())) {
            LOG.info("Update profile : " + user.getUsername());
            User updateUser = userRepository.findOne(user.getId());
            if (updateUser == null) {
                throw new EntityNotFoundException("Entity Not FOUND!!");
            } else {
                updateUser.setAlamat(user.getAlamat());
                updateUser.setNoHp(user.getNoHp());
                updateUser.setEmail(user.getEmail());
                userRepository.save(updateUser);
            }
        }
    }

    @Override
    public void deleteUser(Long userId) throws EntityNotFoundException {
        if (Util.isNotNull(userId)) {
            User deleteUser = userRepository.findOne(userId);
            if (deleteUser == null) {
                throw new EntityNotFoundException("Entity Not FOUND!!");
            } else {
                LOG.info("Deleting user : " + deleteUser.getUsername());
                userRepository.delete(deleteUser);
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("Load user by username : " + username);

        User account = null;
        try {
            account = userRepository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (account == null) {
            LOG.warn("NO SUCH USER!!");
            throw new UsernameNotFoundException("No such user" + username);
        } else if (account.getAuthorities().isEmpty()) {
            LOG.warn("User has no authorities");
            throw new UsernameNotFoundException("User" + username + " has no authorities");
        }

        account.setLastAccessedDate(Calendar.getInstance().getTime());

        try {
            userRepository.save(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public void changePassword(String passLama, String passBaru) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addJabatan(Jabatan jabatan) {
        if (Util.isNotNull(jabatan)) {
            LOG.info("Add jabatan : " + jabatan.getName());
            jabatanRepository.save(jabatan);
        }
    }

    @Override
    public void updateJabatan(Jabatan jabatan) {
        if (Util.isNotNull(jabatan) || Util.isNotNull(jabatan.getId())) {
            LOG.info("Update jabatan : " + jabatan.getName());
            Jabatan updateJabatan = jabatanRepository.findOne(jabatan.getId());
            updateJabatan.setName(jabatan.getName());
            jabatanRepository.save(updateJabatan);
        }
    }

    @Override
    public void deleteJabatan(Long id) {
        if (Util.isNotNull(id)) {
            Jabatan deleteJabatan = jabatanRepository.getOne(id);
            LOG.info("Delete jabatan : " + deleteJabatan.getName());
            jabatanRepository.delete(deleteJabatan);
        }
    }

    @Override
    public Jabatan getJabatan(Long id) {
        LOG.info("Get jabatan by id : " + id);
        Jabatan jabatan = null;
        if (Util.isNotNull(jabatan)) {
            jabatan = jabatanRepository.findOne(id);
        }
        return jabatan;
    }

    @Override
    public Jabatan getJabatan(String jabatanName) {
        LOG.info("Get jabatan by name : " + jabatanName);
        Jabatan jabatan = null;
        if (Util.isNotNull(jabatanName)) {
            jabatan = jabatanRepository.findByName(jabatanName);
        }
        return jabatan;
    }

    @Override
    public List<Jabatan> getJabatans() {
        return jabatanRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        if (Util.isNotNull(role)) {
            LOG.info("Add role : " + role.getAuthority());
            roleRepository.save(role);
        }
    }

    @Override
    public void updateRole(Role role) {
        if (Util.isNotNull(role) || Util.isNotNull(role.getId())) {
            LOG.info("Update role : " + role.getAuthority());
            Role updateRole = roleRepository.findOne(role.getId());
            updateRole.setAuthority(role.getAuthority());
            roleRepository.save(updateRole);
        }
    }

    @Override
    public void deleteRole(Long id) {
        if (Util.isNotNull(id)) {
            Role deleteRole = roleRepository.getOne(id);
            LOG.info("Delete role : " + deleteRole.getId());
            roleRepository.delete(deleteRole);
        }
    }

    @Override
    public Role getRole(Long id) {
        LOG.info("Get role by id : " + id);
        Role role = null;
        if (Util.isNotNull(role)) {
            role = roleRepository.findOne(id);
        }
        return role;
    }

    @Override
    public Role getRole(String authorityName) {
        LOG.info("Get role by name : " + authorityName);
        Role authority = null;
        if (Util.isNotNull(authorityName)) {
            authority = roleRepository.findByAuthority(authorityName);
        }
        return authority;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        if (Util.isNotNull(user) || Util.isNotNull(user.getId())) {
            LOG.info("Update user : " + user.getUsername());
            User updateUser = userRepository.findOne(user.getId());
            if (updateUser == null) {
                throw new EntityNotFoundException("Entity Not FOUND!!");
            } else {
                updateUser.setUsername(user.getUsername());
                updateUser.setNama(user.getNama());
                updateUser.setAlamat(user.getAlamat());
                updateUser.setNoHp(user.getNoHp());
                updateUser.setEmail(user.getEmail());
                updateUser.setEnabled(user.isEnabled());
                updateUser.setAccountNonExpired(user.isAccountNonExpired());
                updateUser.setAccountNonLocked(user.isAccountNonLocked());
                updateUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
                userRepository.save(updateUser);
            }
        }
    }

    @Override
    public DataTablesOutput<User> getDataTablesOutput(DataTablesInput input) {
        return userRepository.findAll(input);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
