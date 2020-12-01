package com.cg.ams.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.AttendanceDao;
import com.cg.ams.service.AttendanceServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttendanceTest {
	@InjectMocks
	private AttendanceServiceImpl attendanceService;
	
	@Mock
	private AttendanceDao attendanceDao;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addAttendanceTest() {
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setCourseId((long) 111);
		attendanceEntity.setCourseName("IT");
		attendanceEntity.setSemester("VII");
		attendanceEntity.setStatus("present");
		attendanceEntity.setStudentId((long) 1695);
		attendanceEntity.setStudentName("durga");
		attendanceEntity.setSubjectId((long) 101);
		attendanceEntity.setSubjectName("DB");
		attendanceEntity.setTotalClassPercentage((long) 97);
		attendanceEntity.setTotalPercentage("99%");
		
		when(attendanceDao.save(attendanceEntity)).thenReturn(attendanceEntity);
		
		Long attendanceId = attendanceService.add(attendanceEntity);
		
		assertEquals("durga", attendanceEntity.getStudentName());
		verify(attendanceDao, times(1)).save(attendanceEntity);
	}
	
	@Test
	public void updateDoctorTest() throws RecordNotFoundException {
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setCourseId((long) 111);
		attendanceEntity.setCourseName("IT");
		attendanceEntity.setSemester("VII");
		attendanceEntity.setStatus("present");
		attendanceEntity.setStudentId((long) 1695);
		attendanceEntity.setStudentName("durga");
		attendanceEntity.setSubjectId((long) 101);
		attendanceEntity.setSubjectName("DB");
		attendanceEntity.setTotalClassPercentage((long) 97);
		attendanceEntity.setTotalPercentage("99%");
		Long attendanceId = attendanceEntity.getAttendanceId();
		Optional<AttendanceEntity> attendanceEntity1 = attendanceDao.findById(attendanceId);
		
		when(attendanceDao.findById(attendanceId)).thenReturn(attendanceEntity1);
		when(attendanceDao.save(attendanceEntity)).thenReturn(attendanceEntity);
		
		attendanceEntity.setCourseId((long) 112);;
		
		attendanceService.update(attendanceEntity);;
		
		assertEquals(112, attendanceEntity.getCourseId());
		verify(attendanceDao, times(1)).save(attendanceEntity);
	}
	
	@Test
	public void viewAttendanceTest() throws RecordNotFoundException {
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setCourseId((long) 111);
		attendanceEntity.setCourseName("IT");
		attendanceEntity.setSemester("VII");
		attendanceEntity.setStatus("present");
		attendanceEntity.setStudentId((long) 1695);
		attendanceEntity.setStudentName("durga");
		attendanceEntity.setSubjectId((long) 101);
		attendanceEntity.setSubjectName("DB");
		attendanceEntity.setTotalClassPercentage((long) 97);
		attendanceEntity.setTotalPercentage("99%");
		Long attendanceId = attendanceEntity.getAttendanceId();
		Optional<AttendanceEntity> attendance = Optional.of(attendanceEntity);
		when(attendanceDao.findById(attendanceId)).thenReturn(attendance);
		
		AttendanceEntity viewAttendance = attendanceService.getAttendanceById(attendanceId);
		
		assertEquals("IT", viewAttendance.getCourseName());;
		verify(attendanceDao, times(1)).findById(attendanceId);
	}
	
	@Test
	public void viewAttendanceListTest() throws RecordNotFoundException {
		List<AttendanceEntity> attendanceList = new ArrayList<AttendanceEntity>();
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setCourseId((long) 111);
		attendanceEntity.setCourseName("IT");
		attendanceEntity.setSemester("VII");
		attendanceEntity.setStatus("present");
		attendanceEntity.setStudentId((long) 1695);
		attendanceEntity.setStudentName("durga");
		attendanceEntity.setSubjectId((long) 101);
		attendanceEntity.setSubjectName("DB");
		attendanceEntity.setTotalClassPercentage((long) 97);
		attendanceEntity.setTotalPercentage("99%");
		
		AttendanceEntity attendanceEntity1 = new AttendanceEntity();
		attendanceEntity1.setCourseId((long) 1112);
		attendanceEntity1.setCourseName("CSE");
		attendanceEntity1.setSemester("VII");
		attendanceEntity1.setStatus("present");
		attendanceEntity1.setStudentId((long) 1696);
		attendanceEntity1.setStudentName("sai");
		attendanceEntity1.setSubjectId((long) 1012);
		attendanceEntity1.setSubjectName("BDBA");
		attendanceEntity1.setTotalClassPercentage((long) 99);
		attendanceEntity1.setTotalPercentage("67%");
		attendanceList.add(attendanceEntity);
		attendanceList.add(attendanceEntity1);
	
		when(attendanceDao.findAll()).thenReturn(attendanceList);
		
		List<AttendanceEntity> attendanceList2 = attendanceService.findAllAttendance();
		
		assertEquals(2, attendanceList2.size());
		verify(attendanceDao, times(1)).findAll();
	}

}
