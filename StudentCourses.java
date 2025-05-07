import java.util.HashMap;
import java.util.Map;

public class StudentCourses {
    private String studentName;
    private Map<String, Map<String, Integer>> semesterCourses; // Semester -> (Course -> Marks)

    public StudentCourses(String studentName) {
        this.studentName = studentName;
        this.semesterCourses = new HashMap<>();
    }

    public void addCourse(String semester, String course, int marks) {
        semesterCourses.putIfAbsent(semester, new HashMap<>());
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCourses() {
        System.out.println("Courses & Marks for Student: " + studentName);
        for (String semester : semesterCourses.keySet()) {
            System.out.println("\nSemester: " + semester);
            for (Map.Entry<String, Integer> entry : semesterCourses.get(semester).entrySet()) {
                System.out.println("Course: " + entry.getKey() + " | Marks: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        StudentCourses studentCourses = new StudentCourses("Alice");
        studentCourses.addCourse("Semester 1", "Math", 85);
        studentCourses.addCourse("Semester 1", "Science", 90);
        studentCourses.addCourse("Semester 2", "History", 88);
        studentCourses.displayCourses();
    }
}