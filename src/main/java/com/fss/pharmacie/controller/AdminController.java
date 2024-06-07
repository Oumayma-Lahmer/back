package com.fss.pharmacie.controller;


import com.fss.pharmacie.models.Admin;
import com.fss.pharmacie.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/list")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }
    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin((admin));
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }


}
