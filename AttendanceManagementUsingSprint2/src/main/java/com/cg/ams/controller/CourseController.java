package com.cg.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.entity.CourseEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.CourseService;

/*
 * @author SaiDurga
 */
//mark class as Controller  
@RestController
@RequestMapping("/api/amsCourse")
public class CourseController {
	// autowire the AttendanceService class
		@Autowired
		CourseService courseService;

		@GetMapping("/hello-world")
		public String sayHello() {
			return "HelloWorld";
		}

		// creating a get mapping that retrieves all the books detail from the database
		@GetMapping("/list")
		private List<CourseEntity> getAllCourse() throws RecordNotFoundException {
			return courseService.findAllCourse();
		}

		// creating post mapping that post the attendance detail in the database
		@PostMapping("/insert")
		public Long create(@RequestBody CourseEntity course) {
			courseService.add(course);
			@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			return course.getCourseId();
		}

		// creating put mapping that updates the attendance detail
		@PutMapping("/update")
		public ResponseEntity<Boolean> update(@RequestBody CourseEntity course) throws RecordNotFoundException{
			courseService.update(course);
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			return responseEntity;
		}

		// creating a delete mapping that deletes a specified student
		@RequestMapping(value = "/delete/{courseId}", method = RequestMethod.DELETE)
		public String deleteCourse(@PathVariable("courseId") Long courseId) throws RecordNotFoundException {
			courseService.deleteByCourseId(courseId);
			return "course has been deleted successfully";
		}

		// creating a get mapping that retrieves the detail of a specific student
		@GetMapping("/find/{courseId}")
		public ResponseEntity<List<CourseEntity>> getCourseById(@PathVariable("courseId") Long courseId)
				throws RecordNotFoundException {
			List<CourseEntity> course = courseService.findByCourseId(courseId);
			return new ResponseEntity<List<CourseEntity>>(course, new HttpHeaders(), HttpStatus.OK);
		}

}
