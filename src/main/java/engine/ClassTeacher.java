package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassTeacher {
    String group_name;
    List<Teacher> Teachers = new ArrayList<>();
    double max_amount;
    double ilosc;

    public String getGroup_name() {
        return group_name;
    }


    public ClassTeacher(String group_name, double max_amount) {
        this.Teachers = new ArrayList<>();
        this.group_name = group_name;
        this.max_amount = max_amount;
        this.ilosc = 0;
    }

    public double getIlosc() {
        return Teachers.size();
    }

    public void addTeacher(Teacher teacher) {
        if (Teachers.size() < max_amount) {
            Teachers.add(teacher);
        } else {
            System.out.println("Nie można dodać więcej nauczycieli do grupy " + group_name);
        }
        ilosc +=1;
    }

    public void printTeachers() {
        System.out.println("Lista nauczycieli w grupie " + group_name + ":");
        for (Teacher teacher : Teachers) {
            System.out.println("Imię: " + teacher.name + ", Nazwisko: " + teacher.surname);
        }
    }

    public List<Teacher> getTeachers() {
        return Teachers;
    }

    void addSalary(Teacher t1, double money) {
        t1.salary += money;
    }

    void removeTeacher(Teacher t1) {
        Teachers.remove(t1);
    }

    void changeCondition(Teacher t1, TeacherCondition condition1) {
        t1.condition = condition1;
    }

    void search(Teacher t1) {
        for (int i = 0; i < Teachers.size(); i++) {
            if (t1.iseq(Teachers.get(i).surname))
                t1.out();
        }
    }

    void partialSearch(String frag) {
        for (int i = 0; i < Teachers.size(); i++) {
            if (Teachers.get(i).surname.contains(frag))
                Teachers.get(i).out();
        }
    }

    int countByCondition(TeacherCondition con) {
        int temp = 0;
        for (int i = 0; i < Teachers.size(); i++)
            if (Teachers.get(i).condition == con)
                temp++;
        return temp;

    }

    void summary() {
        System.out.println("Liczba nauczycieli wynosi " + Teachers.size() + " ,czyli procentowe zapelnienie wynosi " + Teachers.size()/max_amount*100 + "%");
        for (int i = 0; i < Teachers.size(); i++) {
            System.out.println("Nauczyciel nr " + (i + 1));
            Teachers.get(i).out();
        }
    }

    public void sortByName() {
        Collections.sort(Teachers, Comparator.comparing(teacher -> teacher.surname));
    }

    public void sortBySalary() {
        Collections.sort(Teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher teacher1, Teacher teacher2) {
                return -1*Double.compare(teacher1.getSalary(), teacher2.getSalary());
            }
        });
    }

    void maks() {
        List<Double> sal = new ArrayList<>();
        for (int i = 0; i < Teachers.size(); i++)
            sal.add(Teachers.get(i).salary);
        Collections.max(sal);
    }
    public double getMax_amount(){
            return max_amount;
    }

    @Override
    public String toString() {
        return group_name; // lub dowolny inny łańcuch reprezentujący obiekt
    }

}

