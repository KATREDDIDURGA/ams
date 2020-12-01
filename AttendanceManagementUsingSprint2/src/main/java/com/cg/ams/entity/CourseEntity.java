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
	private String name;
	private String description;

	/*
	 * Creating one to many relation with subjects
	 */
//	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//	private Set<SubjectEntity> subjects = new HashSet<>(); // Initialization required to avoid NullPointerException
	/*
	 * creating getters and setters
	 */

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long id) {
		this.courseId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * creating to string method
	 */

	@Override
	public String toString() {
		return "CourseEntity [id=" + courseId + ", name=" + name + ", description=" + description + "]";
	}

	public CourseEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public CourseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

}
