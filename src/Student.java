public class Student {

    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;

    }

    @Override
    public String toString() {
        return String.format("Student(name: %s,score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLastList(new Student("张三", 150));
        arr.addLastList(new Student("张三", 150));
        arr.addLastList(new Student("张三", 150));
        arr.addLastList(new Student("张三", 150));
        System.out.println(arr.toString());

    }
}
