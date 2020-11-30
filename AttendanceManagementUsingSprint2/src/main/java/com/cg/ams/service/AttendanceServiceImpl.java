package com.cg.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.repository.AttendanceDAO;


@Service("service")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceDAO dao ;

	@Override
	public Long add(AttendanceEntity entity) {
		dao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(AttendanceEntity entity) {
		dao.save(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public AttendanceEntity findBySubjectName(String subjectName) {
		return dao.findBySubjectName(subjectName);
		
	}

	@Override
	public AttendanceEntity getAttendanceById(Long id) {
		return dao.findByAttendanceId(id);
	}

	@Override
	public java.util.List<AttendanceEntity> findAllAttendance() {
		return dao.findAll();
	}
	
}
