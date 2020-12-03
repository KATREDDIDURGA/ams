package com.cg.ams.repository;

import java.util.List;
/**

 * This interface is to get the inbuilt CRUD operations for AttendanceEntity

 * 

 * @param JpaRepository<AttendanceEntity, Long>

 * 

 **/

import org.springframework.data.jpa.repository.JpaRepository;
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

}
