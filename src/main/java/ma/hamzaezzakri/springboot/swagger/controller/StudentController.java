package ma.hamzaezzakri.springboot.swagger.controller;

import io.swagger.annotations.ApiOperation;
import ma.hamzaezzakri.springboot.swagger.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hamza Ezzakri
 * @CreatedAt 7/6/2022 3:32 PM
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1L,"Grant","Chanelle"),
            new Student(2L,"Lisette","July"),
            new Student(3L,"Jacki","Bret")
    ));

    @ApiOperation("returns all students")
    @GetMapping("/get-students")
    public ResponseEntity<List<Student>> getAll(){

        return ResponseEntity.ok(students);
    }

    @ApiOperation("returns student by ID")
    @GetMapping("/get-student/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        Student student = students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);

        if(student == null)
            return  ResponseEntity.ok("the student with this id doesn't exist");

        return ResponseEntity.ok(student);
    }

    @ApiOperation("creates student")
    @PostMapping("/save-student")
    public ResponseEntity<?> addStudent(@RequestBody Student student){

        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("student created successfully");
    }

    @ApiOperation("deletes student by ID")
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){

        Student student = students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);

        if(student == null)
            return  ResponseEntity.ok("the student with this id doesn't exist");

        students.remove(student);
        return ResponseEntity.ok("student deleted successfully");
    }
}
