package com.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UniversityController {

    /**
     * Task 1: Welcome endpoint - returns a welcome message
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the University Management System!";
    }

    /**
     * Task 2: Fee endpoint - returns fee as double
     */
    @GetMapping("/fee")
    public double getFee() {
        return 50000.00;
    }

    /**
     * Task 3: Get list of course titles using @GetMapping with root path
     */
    @GetMapping("/courses")
    public List<String> getCoursesList() {
        return Arrays.asList(
            "Java Programming",
            "Web Development",
            "Database Management",
            "Cloud Computing",
            "Data Science"
        );
    }

    /**
     * Task 4: Get course details by ID using @PathVariable
     */
    @GetMapping("/course/{id}")
    public Map<String, Object> getCourseById(@PathVariable("id") String id) {
        Map<String, Object> course = new HashMap<>();
        course.put("courseID", id);
        course.put("title", "Advanced Java Programming");
        course.put("duration", "6 months");
        course.put("fee", 50000.00);
        return course;
    }

    /**
     * Task 5: Search courses by title using @RequestParam
     */
    @GetMapping("/search")
    public Map<String, String> searchCourse(@RequestParam(name = "title", required = true) String title) {
        Map<String, String> result = new HashMap<>();
        result.put("query", title);
        result.put("message", "Search confirmed for course: " + title);
        result.put("status", "Results found!");
        return result;
    }

    /**
     * Edit course endpoint - allows admin to update course details
     */
    @PostMapping("/course/{id}/edit")
    public Map<String, String> editCourse(
            @PathVariable("id") String courseID,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "duration", required = false) String duration,
            @RequestParam(name = "fee", required = false) Double fee) {
        
        Map<String, String> response = new HashMap<>();
        response.put("courseID", courseID);
        response.put("updatedTitle", title != null ? title : "Not updated");
        response.put("updatedDuration", duration != null ? duration : "Not updated");
        response.put("updatedFee", fee != null ? fee.toString() : "Not updated");
        response.put("message", "Course updated successfully!");
        return response;
    }
}