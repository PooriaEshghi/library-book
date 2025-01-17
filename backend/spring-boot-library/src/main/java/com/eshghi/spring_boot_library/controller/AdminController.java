package com.eshghi.spring_boot_library.controller;

  import org.springframework.web.bind.annotation.*;

import com.eshghi.spring_boot_library.requestmodels.AddBookRequest;
import com.eshghi.spring_boot_library.service.AdminService;
import com.eshghi.spring_boot_library.utils.ExtractJWT;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/books")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

     @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader(value="Authorization") String token,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.postBook(addBookRequest);
    }

    
}
