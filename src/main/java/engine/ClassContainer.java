package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer{
    HashMap<String, ClassTeacher> Groups = new HashMap();


    public HashMap<String, ClassTeacher> getGroups() {
        return Groups;
    }

    public void addClass(ClassTeacher cl){
        if (Groups.containsKey(cl.group_name)) {
            System.out.println("Grupa o nazwie " + cl.group_name + " już istnieje.");
            return;
        }
        Groups.put(cl.group_name, cl);
    }

    void removeClass(String key){
        Groups.remove(key);
    }

    public List<String> findEmpty(){
        List<String> emptyGroups = new ArrayList<>();
        for (Map.Entry<String, ClassTeacher> entry : Groups.entrySet()) {
            ClassTeacher classTeacher = entry.getValue();
            if (classTeacher.getTeachers().isEmpty()) {
                emptyGroups.add(entry.getKey());
            }
        }
        return emptyGroups;
    }

    public void summary(){
        for (Map.Entry<String, ClassTeacher> entry : Groups.entrySet()) {
            String className = entry.getKey();
            ClassTeacher classTeacher = entry.getValue();
            List<Teacher> teachers = classTeacher.getTeachers();
            double max_am = classTeacher.getMax_amount();

            double procentowo = (double) teachers.size() / max_am * 100.0;
            System.out.println("Grupa: " + className + ", Zapełnienie: " + procentowo + "%");
        }

    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "Groups=" + Groups +
                '}';
    }
}
