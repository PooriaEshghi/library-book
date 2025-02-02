package com.eshghi.spring_boot_library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshghi.spring_boot_library.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByUserEmail(@RequestParam("user_email") String userEmail, Pageable pageable);

    Page<Message> findByUserClosed(@RequestParam("closed") boolean closed, Pageable pageable);

}
