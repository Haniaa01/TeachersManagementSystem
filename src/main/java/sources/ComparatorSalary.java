package sources;

import java.util.Comparator;

public class ComparatorSalary implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        double salary = o1.getSalary() - o2.getSalary();
        if (salary == 0) {
            return o1.compareTo(o2);
        }
        return (int) salary;
    }
}
