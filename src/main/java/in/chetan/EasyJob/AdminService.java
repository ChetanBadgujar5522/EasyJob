//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminService {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public boolean login(String email, String password) {
//        Admin admin = adminRepository.findByEmail(email);
//        if (admin != null && admin.getPassword().equals(password)) {
//            // Check if the admin is blocked
//            if (admin.isBlocked()) {
//                throw new RuntimeException("Admin account is blocked.");
//            }
//            return true;
//        }
//        return false;
//    }
//}
//
package in.chetan.EasyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            if (admin.isBlocked()) {
                throw new RuntimeException("Admin account is blocked.");
            }
           
            return admin.getPassword().equals(password); 
        }
        return false; 
    }
}

