package com.cg.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * @author SaiDurga
 */
@Entity
@Table(name = "COURSE1")
public class CourseEntity {
	@Id
	@Column(name = "Course_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long courseId;
	private String courseName;
	private String courseDescription;
	/*
	 * getters and setters
	 */
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long id) {
		this.courseId = id;
	}

	public String getName() {
		return courseName;
	}

	public void setName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return courseDescription;
	}

	public void setDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	/*
	 * creating to string method
	 */

	@Override
	public String toString() {
		return "CourseEntity [id=" + courseId + ", name=" + courseName + ", description=" + courseDescription + "]";
	}
	/*
	 * constructor
	 */

	public CourseEntity(String courseName, String courseDescription) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public CourseEntity() {
	}

}
