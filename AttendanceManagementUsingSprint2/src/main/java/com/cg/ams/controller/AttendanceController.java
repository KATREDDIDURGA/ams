package com.cg.ams.controller;

/*
Create string objects in java
Git
Validations
maam pom.xml
Test cases
application.prop
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.AttendanceService;
import org.apache.log4j.Logger;

/*
 * This is a class of controller with methods of 
 * add,update,delete,find..
 * 
 * @author SaiDurga
 */
@RestController
public class AttendanceController {
	/*
	 * autowire the AttendanceService class
	 */
	@Autowired
	private AttendanceService attendanceService;
	
	public static final Logger log = Logger.getLogger(AttendanceController.class.getName());
	/*
	 *  hello world
	 */
	@GetMapping("/hello-world-attendance")
	public String sayHello() {
		return "HelloWorld";
	}

	/*
	 *  creating a get mapping that retrieves all the books detail from the database
	 *  
	 *  @param List<AttendanceEntity>
	 */
	@GetMapping("/list-attendance")
	public List<AttendanceEntity> getAllAttendance() throws RecordNotFoundException {
		log.info("Started Viewing all Attendance Details ");
		@SuppressWarnings("unused")
		ResponseEntity<Boolean> responseEntity;
		log.info("All Attendance Details Viewed");
		return attendanceService.findAllAttendance();
	}

	/*
	 *  creating post mapping that post the attendance detail in the database
	 *  
	 *  @param Long attendanceEntity
	 */
	@PostMapping("/insert-attendance")
	public Long create(@RequestBody AttendanceEntity attendanceEntity) {
		log.info("Started adding attendance Details  ");
		attendanceService.add(attendanceEntity);
		@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity= new ResponseEntity(true, HttpStatus.OK);
		log.info("Completed adding attendance Details  ");
		return attendanceEntity.getAttendanceId();
	}

	/*
	 *  creating put mapping that updates the attendance detail
	 *  
	 *  @param AttendanceEntity attendanceEntity
	 */
	@PutMapping("/update-attendance")
	public ResponseEntity<Boolean> update(@RequestBody AttendanceEntity attendanceEntity) throws RecordNotFoundException {
		log.info("Started updating attendance Details  ");
		attendanceService.update(attendanceEntity);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		log.info("Completed updating attendance Details  ");
		return responseEntity;
	}

	/*
	 *  creating a delete mapping that deletes a specified student
	 *  
	 *  @param Long attendanceId
	 */
	@DeleteMapping(value = "/delete-attendance/{attendanceId}")
	public String deleteAttendance(@PathVariable("attendanceId") Long attendanceId) throws RecordNotFoundException {
		log.info("Started deleting attendance Details ");
		attendanceService.deleteByAttendanceId(attendanceId);
		log.info("Completed deleting attendance Details  ");
		return "student has been deleted successfully";
	}

	/*
	 *  creating a get mapping that retrieves the detail of a specific student
	 *  
	 *  @param Long studentId
	 */
	@GetMapping("/find-student/{studentId}")
	public ResponseEntity<List<AttendanceEntity>> getAttendanceBystudentId(@PathVariable("studentId") Long studentId)
			throws RecordNotFoundException {
		log.info("Started fnding attendance Details By student Id ");
		List<AttendanceEntity> attendance = attendanceService.findByStudentId(studentId);
		log.info("Completed fnding attendance Details  By student Id  ");
		return new ResponseEntity<List<AttendanceEntity>>(attendance, HttpStatus.OK);
	}

	/*
	 *  creating a get mapping that retrieves the detail of a specific student
	 *  
	 *  @param  Long attendanceId
	 */
	@GetMapping("/find-attendance/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable("attendanceId") Long attendanceId)
			throws RecordNotFoundException {
		log.info("Started fnding attendance Details By attendance Id ");
		AttendanceEntity attendance = attendanceService.getAttendanceById(attendanceId);
		log.info("Completed  fnding attendance Details By attendance Id ");
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}
}
