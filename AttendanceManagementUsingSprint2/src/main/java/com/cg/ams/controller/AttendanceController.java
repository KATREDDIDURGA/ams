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
import com.cg.ams.service.AttendanceService;
/*
 * @author SaiDurga
 */
//mark class as Controller  
@RestController
@RequestMapping("/api/amsAttendance")
public class AttendanceController {
	// autowire the AttendanceService class
	@Autowired
	AttendanceService service;

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/getall")
	private List<AttendanceEntity> getAllAttendance() {
		return service.findAllAttendance();
	}

	// creating post mapping that post the attendance detail in the database
	@PostMapping("/insert")
	public Long create(@RequestBody AttendanceEntity attendance) {
		service.add(attendance);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return attendance.getAttendanceId();
	}

	// creating put mapping that updates the attendance detail
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody AttendanceEntity attendance) {
		service.update(attendance);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified student
	@RequestMapping(value = "/delete/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Long studentId) {
		service.deleteByStudentId(studentId);
		return "student has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/findStudent/{studentId}")
	public ResponseEntity<AttendanceEntity> getAttendanceBystudentId(@PathVariable("studentId") Long studentId) {
		AttendanceEntity attendance = service.findByStudentId(studentId);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}
	
	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/find/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable("attendanceId") Long attendanceId) {
		AttendanceEntity attendance = service.getAttendanceById(attendanceId);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}
}
