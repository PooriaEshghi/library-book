package com.eshghi.spring_boot_library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eshghi.spring_boot_library.entity.Book;
import com.eshghi.spring_boot_library.service.BookService;
import com.eshghi.spring_boot_library.utils.ExtractJWT;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestHeader(value = "Authorization") String token,
            @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return bookService.checkoutBook(userEmail, bookId);
    }

     @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization") String token,
                                      @RequestParam Long bookId) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @GetMapping("/secure/currentLoans/count")
    public int currentLoanCount(@RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return bookService.currentLoanCount(userEmail);
    }

}
