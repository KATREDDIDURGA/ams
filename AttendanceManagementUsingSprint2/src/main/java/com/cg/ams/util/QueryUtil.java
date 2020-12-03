package com.cg.ams.util;

public class QueryUtil {
	private QueryUtil() {
	}
	
	public static final String DEL_COURSE_BY_ID= "DELETE from CourseEntity d where d.courseId like ?1";

	public static final String VIEW_STUD_BY_ID = "SELECT a FROM AttendanceEntity a WHERE a.studentId like ?1";

	public static final String DEL_STUD_BY_ID = "DELETE from AttendanceEntity a where a.studentId like ?1";
}
