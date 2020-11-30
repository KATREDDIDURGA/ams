package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.CourseEntity;
/*
 * @author SaiDurga
 */
public interface CourseDAO extends JpaRepository<CourseEntity, Long>{

	// Query to find record of course by id
		@Query("SELECT c FROM CourseEntity c WHERE c.courseId like ?1")
		public CourseEntity findByCourseId(Long courseId);

		// Query to delete record of attendance by id
		@Query("DELETE from CourseEntity d where d.studentId like ?1")
		public CourseEntity deleteByCourseId(Long courseId);

}
