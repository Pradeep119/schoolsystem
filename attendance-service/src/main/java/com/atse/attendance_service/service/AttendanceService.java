package com.atse.attendance_service.service;

import com.atse.attendance_service.dto.StudentDto;
import com.atse.attendance_service.model.AttendanceEntity;
import com.atse.attendance_service.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    WebClient webClient;

    public Boolean saveAttendance(int studentId){

        StudentDto student = webClient.get()
                .uri("http://localhost:8082/api/student/"+studentId)
                .retrieve()
                .bodyToMono(StudentDto.class)
                .block();

        if(student.getId() != 0 && !student.getName().isEmpty()){
            AttendanceEntity attendance = new AttendanceEntity();
            attendance.setStudentId(studentId);
            attendance.setDate(getTodayDate());
            attendanceRepository.save(attendance);
            return true;
        }else{
            return false;
        }
    }

    private static String getTodayDate() {
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(now);
    }

    public List<AttendanceEntity> getStudentsAttendance(){
        return attendanceRepository.findAll();
    }
}
