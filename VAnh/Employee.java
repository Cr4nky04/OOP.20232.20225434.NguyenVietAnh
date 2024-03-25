package VAnh;

public class Employee {
    private String name;
    private long salary;
    private int count;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }

    private void increase()
    {
        count += 1;
    }
    public Employee(String name, long salary)
    {
        setName(name);
        setSalary(salary);
    }

    public int count()
    {
        return count;
    }
    public long totalSalary(Employee... person)
    {
        long sum = 0;
        for (Employee i:
             person) {
            sum += i.getSalary();
        }
        return sum;
    }
}
