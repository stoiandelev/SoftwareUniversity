package SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }


    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",
                firstName, lastName, salary);
    }

    public void increaseSalary(double bonus) {
        //ako човекът е под 30 -> бонуса е на половина
        if (age < 30) {
            bonus /= 2;
        }
        //изчисляване на бонуса
        this.salary = this.salary + this.salary * bonus / 100;
    }
}












