package com.cg.ams.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.util.QueryUtil;

/*
 * @author SaiDurga
 */
public interface AttendanceDao extends JpaRepository<AttendanceEntity, Long> {

	// Query to find record of student by id
	@Query(QueryUtil.VIEW_STUD_BY_ID) // query util
	public List<AttendanceEntity> findByStudentId(Long studentId);

//	// Query to delete record of attendance by id
//	@Query(QueryUtil.DEL_STUD_BY_ID)
//	@Transactional
//	@Modifying
//	public void deleteByAttendanceId(Long attendanceId);

}
