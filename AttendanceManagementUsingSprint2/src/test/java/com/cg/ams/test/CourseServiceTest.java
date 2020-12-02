package com.cg.ams.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.ams.entity.CourseEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.CourseDao;
import com.cg.ams.service.CourseServiceImpl;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseServiceTest {
	@InjectMocks
	private CourseServiceImpl courseService;
	
	@Mock
	private CourseDao courseDao;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addCourseTest() {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setDescription("Intermediate");
		courseEntity.setName("IT");
		
		when(courseDao.save(courseEntity)).thenReturn(courseEntity);
		
		Long courseId = courseService.add(courseEntity);
		
		assertEquals("IT", courseEntity.getName());
		verify(courseDao, times(1)).save(courseEntity);
	}
	
	@Test
	public void updateCourseTest() throws RecordNotFoundException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setDescription("Intermediate");
		courseEntity.setName("IT");
		Long courseId = courseEntity.getCourseId();
		Optional<CourseEntity> courseEntity1 = courseDao.findById(courseId);
		
		when(courseDao.findById(courseId)).thenReturn(courseEntity1);
		when(courseDao.save(courseEntity)).thenReturn(courseEntity);
		
		courseEntity.setName("InfoTech");;
		
		courseService.update(courseEntity);;
		
		assertEquals("InfoTech", courseEntity.getName());
		verify(courseDao, times(1)).save(courseEntity);
	}
	
	@Test
	public void viewCourseByIdTest() throws RecordNotFoundException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setDescription("Intermediate");
		courseEntity.setName("IT");
		Long courseId = courseEntity.getCourseId();
		Optional<CourseEntity> course = Optional.of(courseEntity);
		when(courseDao.findById(courseId)).thenReturn(course);
		
		Optional<CourseEntity> viewCourse = courseDao.findById(courseId);
		
		assertEquals("Intermediate", viewCourse.get().getDescription());;
		verify(courseDao, times(2)).findById(courseId);
	}
	
	@Test
	public void viewCourseListTest() throws RecordNotFoundException {
		List<CourseEntity> courseList = new ArrayList<CourseEntity>();
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setDescription("Intermediate");
		courseEntity.setName("IT");
		
		CourseEntity courseEntity1 = new CourseEntity();
		courseEntity1.setDescription("Beginner");
		courseEntity1.setName("C");
		
		courseList.add(courseEntity);
		courseList.add(courseEntity1);
	
		when(courseDao.findAll()).thenReturn(courseList);
		
		List<CourseEntity> courseList2 = courseService.findAllCourse();
		
		assertEquals(2, courseList2.size());
		verify(courseDao, times(1)).findAll();
	}

}