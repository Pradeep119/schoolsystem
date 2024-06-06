package com.atse.core_service.service;

import com.atse.core_service.dto.ClassRoomDto;
import com.atse.core_service.dto.StudentDto;
import com.atse.core_service.model.ClassRoomEntity;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.repository.ClassRoomRepository;
import com.atse.core_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomRepository classRoomRepository;

    public ClassRoomEntity saveClassRoom(ClassRoomDto classRoomDto){

        ClassRoomEntity classRoom = new ClassRoomEntity();
        classRoom.setGrade(classRoomDto.getGrade());

        classRoomRepository.save(classRoom);
        return classRoom;
    }

    public Optional<ClassRoomEntity> getClassRoom(String classRoomId){
        return classRoomRepository.findById(Integer.valueOf(classRoomId));
    }
}
