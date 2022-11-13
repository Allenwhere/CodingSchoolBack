package controller;

import domain.dto.CourseDTO;
import domain.entity.Course;
import exception.CommonErrorResponse;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.impl.CourseService;

import java.util.Collection;

@RestController
@RequestMapping("/catalog")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer id) {
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<CourseDTO>> getAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
//        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
//    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("Resource Not Found"), HttpStatus.NOT_FOUND);
    }

}
