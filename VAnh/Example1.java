package VAnh;

public class Example1 {
    public static void increase(Student s)
    {
        s = new Student("Hai",22);
        s.setAge(s.getAge()+1);
    }
    public static void swap(int i, int j)
    {

    }
    public static void main(String[] args)
    {
        Student s = new Student("Huy", 20);
        increase(s);
        System.out.println(s.getAge());
    }
}
