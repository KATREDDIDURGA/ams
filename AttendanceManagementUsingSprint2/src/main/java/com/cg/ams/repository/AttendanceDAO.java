package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.AttendanceEntity;

public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Long> {
	@Query("SELECT a FROM AttendanceEntity a WHERE a.attendanceId like ?1")
	public AttendanceEntity findByAttendanceId(Long id);

	@Query("SELECT a FROM AttendanceEntity a WHERE a.studentId like ?1")
	public AttendanceEntity findByStudentId(Long studentId);

	@Query("DELETE from AttendanceEntity a where a.studentId like ?1")
	public AttendanceEntity deleteByStudentId(Long studentId);

}
