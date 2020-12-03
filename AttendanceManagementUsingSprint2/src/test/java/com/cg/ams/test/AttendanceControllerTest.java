package com.cg.ams.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.ResponseEntity;

import com.cg.ams.controller.AttendanceController;
import com.cg.ams.entity.AttendanceEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.repository.AttendanceDao;
import com.cg.ams.service.AttendanceServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttendanceControllerTest {
	@InjectMocks
	private AttendanceController attendanceController;
	@Mock
	private AttendanceServiceImpl attendanceService;
	@Mock
	private AttendanceDao attendanceDao;

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

		@SuppressWarnings("unused")
		Long attendanceId = attendanceController.create(attendanceEntity);

		assertEquals("durga", attendanceEntity.getStudentName());
	}

	@Test
	public void updateAttendanceTest() throws RecordNotFoundException {
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

		attendanceEntity.setCourseId((long) 112);

		attendanceController.update(attendanceEntity);

		assertEquals(112, attendanceEntity.getCourseId());
	}

	@Test
	public void viewAttendanceByIdTest() throws RecordNotFoundException {
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
		when(attendanceController.getAttendanceById(attendanceId).getBody()).thenReturn(attendanceEntity);	
		ResponseEntity<AttendanceEntity> viewAttendance = attendanceController.getAttendanceById(attendanceId);
		assertEquals("IT", viewAttendance.getBody().getCourseName());
	}

	@Test
	public void viewAttendanceListTest() throws RecordNotFoundException {
		List<AttendanceEntity> attendanceList = new ArrayList<AttendanceEntity>();
		AttendanceEntity attendanceEntity = new AttendanceEntity();
		attendanceEntity.setCourseId((long) 111);
		attendanceEntity.setCourseName("IT");
		attendanceEntity.setSemester("VII");
		attendanceEntity.setStatus("present");

		AttendanceEntity attendanceEntity1 = new AttendanceEntity();
		attendanceEntity1.setCourseId((long) 1112);
		attendanceEntity1.setCourseName("CSE");
		attendanceEntity1.setSemester("VII");
		attendanceEntity1.setStatus("present");

		attendanceList.add(attendanceEntity);
		attendanceList.add(attendanceEntity1);
		when(attendanceController.getAllAttendance()).thenReturn(attendanceList);
		List<AttendanceEntity> attendanceList2 = attendanceController.getAllAttendance();
		assertThat(attendanceList2).contains(attendanceEntity);

	}
}
