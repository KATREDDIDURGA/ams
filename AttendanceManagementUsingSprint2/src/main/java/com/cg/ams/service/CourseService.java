package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.CourseEntity;
/*
 * @author SaiDurga
 */
public interface CourseService {

	public Long add(CourseEntity entity);

	public void update(CourseEntity  entity);

	public void deleteByCourseId(Long id);

	public CourseEntity  findByCourseId(Long id);

	public List<CourseEntity > findAllCourse();

}
