package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.AttendanceEntity;
/*
 * @author SaiDurga
 */
public interface AttendanceService {

	public Long add(AttendanceEntity entity);

	public void update(AttendanceEntity entity);

	public void deleteByStudentId(Long id);

	public AttendanceEntity findByStudentId(Long id);

	public AttendanceEntity getAttendanceById(Long id);

	public List<AttendanceEntity> findAllAttendance();

}
