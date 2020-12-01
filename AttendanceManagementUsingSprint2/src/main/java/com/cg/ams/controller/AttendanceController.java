package com.cg.ams.controller;

import java.util.List;

import javax.transaction.Transactional;

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
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.AttendanceService;

/*
 * @author SaiDurga
 */
//mark class as Controller  
@RestController
@RequestMapping("/api/amsattendance")
public class AttendanceController {
	// autowire the AttendanceService class
	@Autowired
	private AttendanceService attendanceService;

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/list")
	private List<AttendanceEntity> getAllAttendance() throws RecordNotFoundException {
		return attendanceService.findAllAttendance();// response entity
	}

	// creating post mapping that post the attendance detail in the database
	@PostMapping("/insert")
	public Long create(@RequestBody AttendanceEntity attendance) {
		attendanceService.add(attendance);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return attendance.getAttendanceId();
	}

	// creating put mapping that updates the attendance detail
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody AttendanceEntity attendance) throws RecordNotFoundException {
		attendanceService.update(attendance);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified student
	@RequestMapping(value = "/delete/{attendanceId}", method = RequestMethod.DELETE)
	public String deleteAttendance(@PathVariable("attendanceId") Long attendanceId) throws RecordNotFoundException {
		attendanceService.deleteByAttendanceId(attendanceId);
		return "student has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/findStudent/{studentId}")
	public ResponseEntity<List<AttendanceEntity>> getAttendanceBystudentId(@PathVariable("studentId") Long studentId)
			throws RecordNotFoundException {
		List<AttendanceEntity> attendance = attendanceService.findByStudentId(studentId);
		return new ResponseEntity<List<AttendanceEntity>>(attendance, HttpStatus.OK);
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/find/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable("attendanceId") Long attendanceId)
			throws RecordNotFoundException {
		AttendanceEntity attendance = attendanceService.getAttendanceById(attendanceId);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}
}
