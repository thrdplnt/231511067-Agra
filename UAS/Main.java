abstract class Employee<T>{
    protected T id;
    protected String name;

    public Employee(T id, String name){
        this.id = id;
        this.name = name;
    }

    public abstract double calculatePayment();
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

class FullTimeEmployee<T> extends Employee<T>{
    private double monthlySalary;

    public FullTimeEmployee(T id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }
}

class PartTimeEmployee<T> extends Employee<T>{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(T id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment(){
        return hourlyRate * hoursWorked ; 
    }
}

public class Main {
    public static void main (String [] args) {
        FullTimeEmployee<Integer> fullTimeEmployee = new FullTimeEmployee<>(802, "Agra", 3000000.00);
        PartTimeEmployee<String> partTimeEmployee = new PartTimeEmployee<>("A606", "Anisa", 100000.0, 30);
    
        fullTimeEmployee.displayDetails();
        System.out.println("Payment: " + fullTimeEmployee.calculatePayment());
    
        partTimeEmployee.displayDetails();
        System.out.println("Payment: " + partTimeEmployee.calculatePayment());
    }
}

