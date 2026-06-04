package emne4PolymorphismSOLID;

public class SRPDemo { //Single Responsibility Principle

    public static void main(String[] args) {

        Employee e = new Employee();
        e.calculateSalary();

        EmployeeRepository repo = new EmployeeRepository();
        repo.save(e);

        EmailService email = new EmailService();
        email.sendEmail("Salary processed");
    }
}

// one class = one job
class Employee {
    public void calculateSalary() {
        System.out.println("Calculating salary...");
    }
}

class EmployeeRepository {
    public void save(Employee e) {
        System.out.println("Saving employee to DB...");
    }
}

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
