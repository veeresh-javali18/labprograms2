import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

 class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dob) {
        this.name = name;
        
        this.dob = parseDate(dob);
        if (this.dob == null) {
            throw new IllegalArgumentException("Invalid date format: " + dob);
        }
    }

    private LocalDate parseDate(String dob) {
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        };
        
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(dob, formatter);
            } catch (DateTimeParseException ignored) {
                // Try the next format
            }
        }
        return null;
    }

    public void displayStudentDetails() {
        int age = Period.between(dob, LocalDate.now()).getYears();

        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age + " years");
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice", "15-08-2000");
        Student student2 = new Student("Bob", "2002-05-20");

        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}

