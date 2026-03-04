public class Student {


    String name;
    int age;
    int id;

    public Student(String name , int age , int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    void showStudents (){
        System.out.println(this.name + " are "+this.age+" years old"+" and his id numebr is "+this.id);
    }

}
