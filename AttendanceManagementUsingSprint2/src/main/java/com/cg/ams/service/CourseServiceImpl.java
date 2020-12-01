package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.CourseEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.CourseDao;
import com.cg.ams.util.ErrorMessageUtil;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(CourseEntity courseEntity) {
		courseDao.save(courseEntity);
		return courseEntity.getCourseId();
	}

	// updating a record
	@Override
	public void update(CourseEntity courseEntity) throws RecordNotFoundException {
		if (courseDao.findByCourseId(courseEntity.getCourseId()) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.ENTITY_NOT_FOUND);
		}
		courseDao.save(courseEntity);

	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	@Override
	public void deleteByCourseId(Long courseId) throws RecordNotFoundException {
		if (courseDao.findByCourseId(courseId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		courseDao.deleteById(courseId);
	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public List<CourseEntity> findByCourseId(Long courseId) throws RecordNotFoundException {
		if (courseDao.findByCourseId(courseId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		return courseDao.findByCourseId(courseId);
	}

	// getting all attendance records by using the method findAll() ofCrudRepository
	@Override
	public List<CourseEntity> findAllCourse() throws RecordNotFoundException {
		List<CourseEntity> course = new ArrayList<CourseEntity>();
		courseDao.findAll().forEach(course1 -> course.add((CourseEntity) course1));
		return course;
	}

}
