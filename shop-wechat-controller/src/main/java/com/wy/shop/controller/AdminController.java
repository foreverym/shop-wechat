package com.wy.shop.controller;

import com.wy.shop.entity.Admin;
import com.wy.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
//    @Autowired
//    private RedisUtil redisUtil;

    @GetMapping("/getAdmin")
    @ResponseBody
    public Admin getAdmin() {
        Admin admin = new Admin();
//        admin.setId(1);
//        admin.setPassword("12333");
//        admin.setUsername("张飒飒");
//        redisUtil.setValue("admin", admin);
//        System.out.println(redisUtil.getValue("admin"));
        System.out.println(admin);
        return admin;
    }


    @GetMapping("/update")
    @ResponseBody
    public void updateUsername() {
        adminService.update();
    }

}
