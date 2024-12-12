import java.util.ArrayList;
import java.util.List;

class Employee<T> {
    private final List<Observer<T>> observers = new ArrayList<>();
    private T state;

    public void addObserver(Observer<T> observer) {
        observers.add(observer); 
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);  
    }

    public void setState(T state) {
        this.state = state;
        notifyObservers();  
    }

    private void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update(state); 
        }
    }

    interface Observer<T> {
        void update(T state);  
    }
}

class EmployeeObserver<T> implements Employee.Observer<T> {
    private final String name;

    public EmployeeObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(T state) {
        System.out.println(name + " menerima notifikasi: " + state);
    }
}

public class EmployeeObserverExample {
    public static void main(String[] args) {
        Employee<String> employee = new Employee<>();
        EmployeeObserver<String> hrObservers = new EmployeeObserver<>("HR Department");
        EmployeeObserver<String> managerObservers = new EmployeeObserver<>("Manager");
        employee.addObserver(hrObservers);  
        employee.addObserver(managerObservers);  
        employee.setState("Nama berubah menjadi [Agra]");
        employee.setState("Gaji berubah menjadi 50000000");
    }
}