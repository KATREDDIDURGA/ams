package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.AttendanceDao;
import com.cg.ams.util.ErrorMessageUtil;

/*
 * @author SaiDurga
 */
//defining the business logic  
@Service("service")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceDao attendanceDao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(AttendanceEntity attendanceEntity) {
		attendanceDao.save(attendanceEntity);
		return attendanceEntity.getAttendanceId();
	}

	// updating a record
	@Override
	public void update(AttendanceEntity attendanceEntity) throws RecordNotFoundException {
		if (attendanceDao.findByStudentId(attendanceEntity.getAttendanceId()) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.ENTITY_NOT_FOUND);
		}
		attendanceDao.save(attendanceEntity);

	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	@Override
	public void deleteByAttendanceId(Long attendanceId) throws RecordNotFoundException {
		if (attendanceDao.findById(attendanceId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		attendanceDao.deleteById(attendanceId);
	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public List<AttendanceEntity> findByStudentId(Long studentId) throws RecordNotFoundException {
		if (attendanceDao.findByStudentId(studentId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		return attendanceDao.findByStudentId(studentId);

	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public AttendanceEntity getAttendanceById(Long attendanceId) throws RecordNotFoundException {
		Optional<AttendanceEntity> attendance = attendanceDao.findById(attendanceId);
		if (attendance.isEmpty()) {
			throw new RecordNotFoundException(ErrorMessageUtil.ATT_RECORD_NOT_FOUND);
		}
		return attendance.get();
	}

	// getting all attendance records by using the method findaAll() of
	// CrudRepository
	@Override
	public List<AttendanceEntity> findAllAttendance() throws RecordNotFoundException {
		List<AttendanceEntity> attendance = new ArrayList<AttendanceEntity>();
		attendanceDao.findAll().forEach(attendance1 -> attendance.add(attendance1));
		return attendance;
	}

}
