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
import com.cg.ams.entity.CourseEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.CourseService;
import org.apache.log4j.Logger;

/*
 * This is a class of controller with methods of 
 * add,update,delete,find..
 * 
 * @author SaiDurga
 */
@RestController
public class CourseController {
	/*
	 * autowire the AttendanceService class
	 */
	@Autowired
	CourseService courseService;
	
	public static final Logger log = Logger.getLogger(CourseController .class.getName());
	/*
	 *  hello world
	 */
	@GetMapping("/hello-world/course")
	public String sayHello() {
		return "HelloWorld";
	}

	/*
	 *  creating a get mapping that retrieves all the books detail from the database
	 *  
	 *   @param List<CourseEntity>
	 */
	@GetMapping("/list-course")
	public List<CourseEntity> getAllCourse() throws RecordNotFoundException {
		log.info("Started Viewing all Course Details ");
		return courseService.findAllCourse();
	}

	/*
	 *  creating post mapping that post the attendance detail in the database
	 *  
	 *  @param CourseEntity courseEntity
	 */
	@PostMapping("/insert-course")
	public Long create(@RequestBody CourseEntity courseEntity) {
		log.info("Started adding  Course Details ");
		courseService.add(courseEntity);
		log.info("Completed adding Course Details ");
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return courseEntity.getCourseId();
	}

	/*
	 *  creating put mapping that updates the attendance detail
	 *  
	 *  @param CourseEntity courseEntity
	 */
	@PutMapping("/update-course")
	public ResponseEntity<Boolean> update(@RequestBody CourseEntity courseEntity) throws RecordNotFoundException {
		log.info("Started updating Course Details ");
		courseService.update(courseEntity);
		log.info("Completed updating Course Details ");
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	/*
	 *  creating a delete mapping that deletes a specified student
	 *  
	 *  @param  Long courseId
	 */
	@RequestMapping(value = "/delete-course/{courseId}", method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable("courseId") Long courseId) throws RecordNotFoundException {
		log.info("Started deleting Course Details ");
		courseService.deleteByCourseId(courseId);
		log.info("completed deleting all Course Details ");
		return "course has been deleted successfully";
	}

	/*
	 *  creating a get mapping that retrieves the detail of a specific student
	 *  
	 *  @param Long courseId
	 */
	@GetMapping("/find-course/{courseId}")
	public ResponseEntity<CourseEntity> getCourseById(@PathVariable("courseId") Long courseId)
			throws RecordNotFoundException {
		log.info("Started retireving Course Details by id");
		CourseEntity course = courseService.getCourseById(courseId);
		log.info("completed retireving Course Details by id");
		return new ResponseEntity<CourseEntity>(course, new HttpHeaders(), HttpStatus.OK);
	}

}
