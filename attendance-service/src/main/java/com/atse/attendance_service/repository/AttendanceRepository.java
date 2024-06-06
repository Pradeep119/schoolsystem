package com.atse.attendance_service.repository;

import com.atse.attendance_service.model.AttendanceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Integer> {

    @Override
    List<AttendanceEntity> findAll();
}
