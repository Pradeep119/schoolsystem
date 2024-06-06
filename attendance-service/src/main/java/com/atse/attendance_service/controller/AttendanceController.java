package com.atse.attendance_service.controller;

import com.atse.attendance_service.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mark")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> initialize(@PathVariable Integer studentId) {

        boolean bool = attendanceService.saveAttendance(studentId);

        if(bool){
            return ResponseEntity.ok("Succeeded");
        }else{
            return ResponseEntity.ok("Attendance mark failed");
        }
    }
}
