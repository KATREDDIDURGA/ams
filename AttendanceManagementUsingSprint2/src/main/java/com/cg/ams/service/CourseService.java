package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.CourseEntity;
import com.cg.ams.exception.RecordNotFoundException;
/*
 * @author SaiDurga
 */
public interface CourseService {

	public Long add(CourseEntity entity);

	public void update(CourseEntity  entity) throws RecordNotFoundException;

	public void deleteByCourseId(Long id) throws RecordNotFoundException;

	public List<CourseEntity>  findByCourseId(Long id) throws RecordNotFoundException;

	public List<CourseEntity > findAllCourse() throws RecordNotFoundException;
	

}
