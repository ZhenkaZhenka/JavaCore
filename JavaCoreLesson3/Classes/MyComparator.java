package JavaCoreLesson3.Classes;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.surname.compareTo(o2.surname) == 0){
            return o1.name.compareTo(o2.name);
        }
        return o1.surname.compareTo(o2.surname);
    }
}
