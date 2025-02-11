package week4.day_1;

import java.util.ArrayList;
import java.util.List;

// Abstract class for Course Types
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + courseName;
    }
}

// Subclasses for different course types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

// Generic course class to manage different courses
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public void displayCourses() {
        for (T course : courses) {
            System.out.println(course);
        }
    }
}

// Utility class to display all courses regardless of type
class UniversityUtility {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to demonstrate functionality
public class MultilevelUniversityCourseManagementSystem  {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Programming"));
        examCourses.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History"));
        assignmentCourses.addCourse(new AssignmentCourse("Geography"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence"));
        researchCourses.addCourse(new ResearchCourse("Computer Network"));

        // Display individual course categories
        System.out.println("Exam Courses:");
        examCourses.displayCourses();

        System.out.println("\nAssignment Courses:");
        assignmentCourses.displayCourses();

        System.out.println("\nResearch Courses:");
        researchCourses.displayCourses();

        // Using wildcard method to display courses of any type

        UniversityUtility.displayAllCourses(examCourses.getCourses());
        UniversityUtility.displayAllCourses(assignmentCourses.getCourses());
        UniversityUtility.displayAllCourses(researchCourses.getCourses());
    }
}

