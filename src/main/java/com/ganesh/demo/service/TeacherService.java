package com.ganesh.demo.service;

import java.util.Objects;
import java.util.List;

import com.ganesh.demo.dto.TeacherResponse;
import com.ganesh.demo.model.Teacher;
import com.ganesh.demo.repository.TeacherRepository;

import org.springframework.stereotype.Service;


@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponse addTeacher(Teacher teacher){
        return new TeacherResponse("Teacher added successfully!",teacherRepository.save(teacher));
    }
    
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById (Long id){
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher deleteTeacherById(Long id){
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(Objects.nonNull(teacher)){
            teacherRepository.deleteById(id);
            return teacher;
        } else {
            return null;
        }
    }
}
