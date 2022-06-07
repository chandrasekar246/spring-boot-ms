package com.github.chandrasekar246.java8.demo.uc3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {
	
	private static final String CPGM = "C";
	private static final String CPP = "CPP";
	private static final String JAVA = "JAVA";

	private static final Course COURSE_CPGM = new Course("PGM001", CPGM, LocalDate.of(2022, 1, 25), LocalDate.of(2022, 2, 24));
	private static final Course COURSE_CPP = new Course("PGM002", CPP, LocalDate.of(2022, 2, 25), LocalDate.of(2022, 3, 24));
	private static final Course COURSE_JAVA = new Course("PGM003", JAVA, LocalDate.of(2022, 3, 25), LocalDate.of(2022, 4, 24));
	
	private static final List<Course> COURSE_LIST = Arrays.asList(COURSE_CPGM, COURSE_CPP, COURSE_JAVA);
	
	private static List<Student> studentList;

	public static void main(String[] args) {

		Map<String, Double> anandScore = new HashMap<>();
		anandScore.put(CPGM, 88.5);
		anandScore.put(JAVA, 88.5);
		Student anand = new Student("XIIA001", "Anand", Arrays.asList(COURSE_CPGM, COURSE_JAVA), anandScore);

		Map<String, Double> balajiScore = new HashMap<>();
		anandScore.put(CPP, 88.5);
		anandScore.put(JAVA, 88.5);
		Student balaji = new Student("XIIA002", "Balaji", Arrays.asList(COURSE_CPP, COURSE_JAVA), balajiScore);

		Map<String, Double> chandraScore = new HashMap<>();
		anandScore.put(JAVA, 88.5);
		anandScore.put(CPP, 88.5);
		Student chandra = new Student("XIIA003", "Chandra", Arrays.asList(COURSE_JAVA, COURSE_CPP), chandraScore);

		studentList = Arrays.asList(anand, balaji, chandra);

		System.out.println("====== Students Enrolled For JAVA ======");
		List<Student> studentsEnrolled = getStudentEnrolledForCourse(JAVA);
		System.out.println(studentsEnrolled);

//		System.out.println(getAverageScoreForCourse(CPP));
		
		LocalDate today = LocalDate.of(2022, 1, 26);
		System.out.println("\n====== Next Week ======");
		System.out.println(getAvailableCoursesFallsInPeriod(today.plusWeeks(1)));
		System.out.println("====== Next Month ======");
		System.out.println(getAvailableCoursesFallsInPeriod(today.plusMonths(1)));
	}

	private static List<Course> getAvailableCoursesFallsInPeriod(LocalDate plusWeeks) {
		return COURSE_LIST.stream().filter(course -> plusWeeks.isAfter(course.getStartDate()) && plusWeeks.isBefore(course.getEndDate())).toList();
	}

//	private static Double getAverageScoreForCourse(String course) {
//		Double avg =  studentList.stream().filter(student -> student.getCourseEnrolled().stream().map(Course::getTitle)
//				.anyMatch(title -> title.equals(course))).collect(Collectors.averagingDouble(null)
//				
//				return avg;
//	}

	private static List<Student> getStudentEnrolledForCourse(String course) {
		return studentList.stream().filter(student -> student.getCourseEnrolled().stream().map(Course::getTitle)
				.anyMatch(title -> title.equals(course))).toList();
	}

}
