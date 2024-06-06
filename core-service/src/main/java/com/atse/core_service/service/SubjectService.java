package com.atse.core_service.service;

import com.atse.core_service.dto.SubjectDto;
import com.atse.core_service.model.SubjectEntity;
import com.atse.core_service.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public SubjectEntity saveSubject(SubjectDto subjectDto){

        SubjectEntity subject  = new SubjectEntity();
        subject.setSubjectName(subjectDto.getName());

        subjectRepository.save(subject);
        return subject;
    }

    public Optional<SubjectEntity> getSubject(String subjectId){
        return subjectRepository.findById(Integer.valueOf(subjectId));
    }
}
