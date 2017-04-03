/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.services;


import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author mridwan
 */
public interface UserService extends UserDetailsService {

    User getUser(Long userId) throws NullPointerException, EntityNotFoundException;

    User getUser(String username) throws NullPointerException, EntityNotFoundException;

    void addUser(User user) throws NullPointerException;

    void updateUser(User user) throws NullPointerException, EntityNotFoundException;

    void deleteUser(Long userId) throws NullPointerException, EntityNotFoundException;

    List<User> getUser();

    void assignRoleToUser(Role role, User user) throws NullPointerException, EntityNotFoundException;

}
