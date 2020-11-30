package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.ams.entity.CourseEntity;
import com.cg.ams.repository.CourseDAO;

public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseDAO dao;

	// saving a specific record by using the method save() of CrudRepository
		@Override
		public Long add(CourseEntity entity) {
			dao.save(entity);
			return entity.getId();
		}

		// updating a record
		@Override
		public void update(CourseEntity entity) {
			dao.save(entity);

		}

		// deleting a specific record by using the method deleteById() of CrudRepository
		@Override
		public void deleteByCourseId(Long courseId) {
			dao.deleteById(courseId);
		}

		// getting a specific record by using the method findById() of CrudRepository
		@Override
		public CourseEntity findByCourseId(Long courseId) {
			return dao.findByCourseId(courseId);
		}

		// getting all attendance records by using the method findaAll() of  CrudRepository
		@Override
		public List<CourseEntity> findAllCourse() {
			List<CourseEntity> course = new ArrayList<CourseEntity>();
			dao.findAll().forEach(course1 -> course.add((CourseEntity) course1));
			return course;
		}

}
