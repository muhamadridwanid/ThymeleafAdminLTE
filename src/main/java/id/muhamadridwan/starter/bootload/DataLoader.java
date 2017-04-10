/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.bootload;

import id.muhamadridwan.starter.models.Jabatan;
import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import id.muhamadridwan.starter.services.UserManagemenService;

/**
 *
 * @author mridwan
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserManagemenService userService;
     

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        System.out.println("Starting data loading");

        Jabatan jabatan_developer = new Jabatan("Developer");
        Jabatan jabatan_tester = new Jabatan("Tester");

        userService.addJabatan(jabatan_developer);
        userService.addJabatan(jabatan_tester);

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        

        userService.addRole(roleAdmin);
        userService.addRole(roleUser);

        User adminUser = new User("ridwan","Muhamad Ridwan", "me@muhamadridwan.id", jabatan_developer);
        adminUser.setAuthority(roleAdmin);
        
        User testUser = new User("test",  "test",  "test@gmail.com", jabatan_tester);
        testUser.setAuthority(roleUser);

        userService.addUser(adminUser);
        userService.addUser(testUser);


    }

}
