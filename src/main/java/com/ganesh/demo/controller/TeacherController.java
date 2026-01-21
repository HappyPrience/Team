package com.ganesh.demo.controller;

import java.util.List;
import java.util.Objects;

import com.ganesh.demo.dto.TeacherResponse;
import com.ganesh.demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.demo.model.Teacher;



@RestController
@RequestMapping("/Teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/teacher")
    public TeacherResponse addTeacher(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("/teacher/{id0}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id){
        Teacher teacher = teacherService.getTeacherById(id);
        if(teacher == null){

            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(teacher);
        }
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<String> deleteTeacherbyId(@PathVariable("id")Long id){
        Teacher teacher = teacherService.deleteTeacherById(id);
        if(Objects.nonNull(teacher)){
            return ResponseEntity.ok().body("Teacher deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}