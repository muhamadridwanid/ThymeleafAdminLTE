/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.controllers;

import id.muhamadridwan.starter.utils.AjaxResponseBody;
import com.fasterxml.jackson.annotation.JsonView;
import id.muhamadridwan.starter.models.Jabatan;
import id.muhamadridwan.starter.models.Role;
import id.muhamadridwan.starter.models.User;
import id.muhamadridwan.starter.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import id.muhamadridwan.starter.services.UserManagemenService;
import id.muhamadridwan.starter.services.impl.UserManagementServiceImpl;
import id.muhamadridwan.starter.validators.CreateUserForm;
import java.util.HashMap;

import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author mridwan
 */
@Controller
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserManagemenService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = {"/", "/home"})
    public String index() {
        return "pages/index/index";
    }

    @GetMapping("/admin/user")
    public ModelAndView index2() {
        List<Jabatan> getJabatans = userService.getJabatans();
        List<Role> getRoles = userService.getRoles();

        ModelAndView mav = new ModelAndView("pages/user/index");
        mav.addObject("user", new CreateUserForm());
        mav.addObject("jabatans", getJabatans);
        mav.addObject("roles", getRoles);

        return mav;
    }

    /**
     *
     * @param user
     * @param errors
     * @param model
     * @return
     */
    @PostMapping("/admin/user")
    public String storeUser(@Valid @ModelAttribute("user") CreateUserForm user, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "pages/user/index";
        } else {
            LOG.info("SAVE USER");
            LOG.info(user.toString());            
            User createUser = new User(user.getUsername(), user.getNama(), user.getEmail(), user.getRoleId(), user.getJabatanId());
            userService.addUser(createUser);
            return "redirect:/admin/user";
        }

    }

    @GetMapping("/admin/dttable")
    @JsonView(DataTablesOutput.View.class)
    @ResponseBody
    public DataTablesOutput<User> getListUser(@Valid DataTablesInput input) {
        return userService.getDataTablesOutput(input);
    }

    @PostMapping("/admin/userw")
    public ResponseEntity<?> postUser(@Valid @RequestBody User user, Errors errors) {
        LOG.info("SAVE USER");
        AjaxResponseBody result = new AjaxResponseBody();

        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(", ")));
            return ResponseEntity.badRequest().body(result);
        } else {
            result.setMsg("OKK");
            return ResponseEntity.ok(result);
        }
    }

}
