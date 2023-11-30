package sources;

import java.util.Objects;

public class Teacher implements Comparable<Teacher> {
    String name;
    TeacherCondition condition;
    String surname;
    int year_of_birth;
    double salary;

    public Teacher(String name, TeacherCondition condition, String surname, int year_of_birth, double salary){
        this.name = name;
        this.condition = condition;
        this.surname = surname;
        this.year_of_birth = year_of_birth;
        this.salary = salary;
    }
    public Teacher(){
        this.name = "";
        this.surname = "";
        this.salary = 0;
        this.condition = TeacherCondition.valueOf("");
        this.year_of_birth = 1900;
    }

    void out(){
        System.out.println("Name = " + name + "\n" +
                "Surname = " + surname + "\n" +
                "TeacherCondition = " + condition + "\n" +
                "Year of birth = " + year_of_birth + "\n" +
                "Salary = " + salary + "\n");
    }

    public String getName() {
        return name;
    }

    public TeacherCondition getCondition() {
        return condition;
    }

    public  String getSurname() {
        return surname;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }



    public Boolean iseq(String sur1) {
        return Objects.equals(sur1, this.surname);
    }
    @Override
    public int compareTo(Teacher other) {
        int temp= surname.compareTo(other.surname);
        if(temp == 0)
            return name.compareTo(other.name);
        else
            return temp;

    }
    @Override
    public int compareTobySalary(Teacher other){
        if(this.salary > other.salary)
            return 1;
        return 0;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCondition(TeacherCondition condition) {
        this.condition = condition;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
