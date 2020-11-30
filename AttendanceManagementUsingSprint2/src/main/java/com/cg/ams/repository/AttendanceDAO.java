package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.AttendanceEntity;


public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Long>{
	@Query("SELECT a FROM AttendanceEntity a WHERE a.id like ?1")
	public AttendanceEntity findByAttendanceId(Long id);
	
	@Query("SELECT a FROM AttendanceEntity a WHERE a.subjectName like ?1")
	public AttendanceEntity findBySubjectName(String subjectName);

}
