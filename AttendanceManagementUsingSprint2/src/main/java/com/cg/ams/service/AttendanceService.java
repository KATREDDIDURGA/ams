package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.AttendanceEntity;

public interface AttendanceService {

	public Long add(AttendanceEntity entity);

	public void update(AttendanceEntity entity);

	public void deleteById(Long id);

	public AttendanceEntity findBySubjectName(String name);

	public AttendanceEntity getAttendanceById(Long id);

	public List<AttendanceEntity> findAllAttendance();

}
