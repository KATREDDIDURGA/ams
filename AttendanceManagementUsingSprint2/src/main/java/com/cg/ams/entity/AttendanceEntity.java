package com.cg.ams.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/*
 * @author SaiDurga
 */
@Entity
@Table(name = "attendancetable")
public class AttendanceEntity {
	@Id
	@Column(name = "ATTENDANCE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long attendanceId;
	@NotNull
	@Column(name = "SUBJ_ID", length = 10)
	private Long subjectId;
	@NotNull
	@Column(name = "SUBJ_NAME", length = 10)
	private String subjectName;
	@NotNull
	@Column(name = "STUD_ID", length = 10)
	private Long studentId;
	@NotNull
	@Column(name = "STUD_NAME", length = 20)
	private String studentName;
	@NotNull
	@Column(name = "SEMESTER", length = 3)
	private String semester;
//	@NotNull
//	@Column(name = "T_DATE")
//	private LocalDate date;
//	@NotNull
//	@Column(name = "TOTAL_CLASS", length = 2)
//	private String totalClass;
//	@NotNull
//	@Column(name = "STATUS", length = 10)
//	private Long status;
	@NotNull
	@Column(name = "TOTAL_PERCENTAGE", length = 3)
	private Long totalClassPercentage;
	@NotNull
	@Column(name = "PERCENTAGE")
	private String percentage;
	@NotNull
	@Column(name = "COURSE_ID", length = 6)
	private Long courseId;
	@NotNull
	@Column(name = "COURSE_NAME", length = 30)
	private String courseName;
	/*
	 * Creating getters and setters for above properties
	 */

	public Long getId() {
		return attendanceId;
	}

	public void setId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public String getTotalClass() {
//		return totalClass;
//	}
//
//	public void setTotalClass(String totalClass) {
//		this.totalClass = totalClass;
//	}
//
//	public Long getStatus() {
//		return status;
//	}
//
//	public void setStatus(Long status) {
//		this.status = status;
//	}

	public Long getTotal() {
		return totalClassPercentage ;
	}

	public void setTotal(Long total) {
		this.totalClassPercentage  = total;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/*
	 * ToString method for above variables
	 */

	@Override
	public String toString() {
		return "AttendanceEntity [id=" + attendanceId + ", subjectId=" + subjectId + ", subjectName=" + subjectName
				+ ", studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester + /*", date="
				+ date + */", totalClass=" + totalClassPercentage + /*", status=" + status + ", total=" + total + */", percentage="
				+ percentage + ", courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	/*
	 * constructor
	 */

	public AttendanceEntity(Long subjectId, String subjectName, Long studentId, String studentName, String semester,
			/*LocalDate date, String totalClass, Long status,*/ Long total, String percentage, Long courseId,
			String courseName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.semester = semester;
//		this.date = date;
//		this.totalClass = totalClass;
//		this.status = status;
		this.totalClassPercentage  = totalClassPercentage ;
		this.percentage = percentage;
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public AttendanceEntity() {
		super();
	}

}
