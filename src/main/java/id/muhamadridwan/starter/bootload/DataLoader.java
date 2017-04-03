/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.bootload;

import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import id.muhamadridwan.starter.services.RoleService;
import id.muhamadridwan.starter.services.UserService;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author mridwan
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        System.out.println("Starting data loading");
        User adminUser = new User("admin", passwordEncoder.encode("admin"), "admin", "adminLastname", "admin@gmail.com");
        User testUser = new User("test", passwordEncoder.encode("test"), "test", "testLastname", "test@gmail.com");

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        userService.addUser(adminUser);

        userService.addUser(testUser);

        userService.assignRoleToUser(roleAdmin, adminUser);
        userService.assignRoleToUser(roleUser, adminUser);
        userService.assignRoleToUser(roleUser, testUser);

    }

}
