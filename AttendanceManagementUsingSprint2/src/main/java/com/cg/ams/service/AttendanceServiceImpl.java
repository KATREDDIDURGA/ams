package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.repository.AttendanceDAO;
/*
 * @author SaiDurga
 */
//defining the business logic  
@Service("service")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceDAO dao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(AttendanceEntity entity) {
		dao.save(entity);
		return entity.getAttendanceId();
	}

	// updating a record
	@Override
	public void update(AttendanceEntity entity) {
		dao.save(entity);

	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	@Override
	public void deleteByStudentId(Long StudentId) {
		dao.deleteById(StudentId);
	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public AttendanceEntity findByStudentId(Long studentId) {
		return dao.findByStudentId(studentId);

	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public AttendanceEntity getAttendanceById(Long attendanceId) {
		return dao.findByAttendanceId(attendanceId);
	}

	// getting all attendance records by using the method findaAll() of  CrudRepository
	@Override
	public List<AttendanceEntity> findAllAttendance() {
		List<AttendanceEntity> attendance = new ArrayList<AttendanceEntity>();
		dao.findAll().forEach(attendance1 -> attendance.add((AttendanceEntity) attendance));
		return attendance;
	}

}
