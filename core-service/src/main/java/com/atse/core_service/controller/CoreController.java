package com.atse.core_service.controller;

import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.service.CoreService;
import com.atse.core_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/init")
public class CoreController {

    @Autowired
    CoreService coreService;

    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> initialize() {
        coreService.initializeData();
        return ResponseEntity.ok("Data Initialized");
    }
}
