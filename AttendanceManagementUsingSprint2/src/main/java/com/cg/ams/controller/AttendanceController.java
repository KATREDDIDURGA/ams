package com.cg.ams.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.service.AttendanceService;

@RestController
@RequestMapping("/api/attendanceManagementSystem")
public class AttendanceController {
	@Autowired
	AttendanceService service;

	@PostMapping("/insert")
	public Long create(@RequestBody AttendanceEntity attendance) {
		service.add(attendance);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return attendance.getId();
	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody AttendanceEntity attendance) {
		service.update(attendance);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete")
	public void deleteAttendanceById(@RequestParam Long id) {
		service.deleteById(id);
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<AttendanceEntity> getAttendanceBySubjectName(@PathVariable("name") String subjectName) {
		@SuppressWarnings("unused")
		AttendanceEntity attendance = service.findBySubjectName(subjectName);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable("attendanceId") Long attendanceId) {
		@SuppressWarnings("unused")
		AttendanceEntity attendance = service.getAttendanceById(attendanceId);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getAll")
	public ResponseEntity<List<AttendanceEntity>> findAllAttendance(@PathVariable("attendanceId") Long attendanceId) {
		AttendanceEntity attendance = service.getAttendanceById(attendanceId);
		return new ResponseEntity<List<AttendanceEntity>>((List<AttendanceEntity>) attendance, new HttpHeaders(),
				HttpStatus.OK);
	}

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}

}
