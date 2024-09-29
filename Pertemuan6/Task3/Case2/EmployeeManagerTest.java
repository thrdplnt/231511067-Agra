package Pertemuan6.Task3.Case2;

public class EmployeeManagerTest {
    public static void main(String[] args) {
        Sortable[] staff = new Sortable[3];
        staff[0] = new Employee("Antonio Rossi", 3500000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        System.out.println("Before sorting:");
        printStaff(staff);

        Sortable.shell_sort(staff);

        System.out.println("\nAfter sorting:");
        printStaff(staff);
    }

    private static void printStaff(Sortable[] staff) {
        for (Sortable e : staff) {
            ((Employee) e).print(); 
        }
    }
}