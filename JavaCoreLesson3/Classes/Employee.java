package JavaCoreLesson3.Classes;

import java.util.Scanner;

public abstract class Employee{
    public String name;
    public String surname;
    abstract double salary();

    public abstract String toString();

    double getDouble(String message){
        System.out.println(message);
        while(true) {
            try {
                Scanner in = new Scanner(System.in);
                double number = in.nextDouble();
                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не дробное число или перепутали ',' с '.', попробуйте еще");
            }
        }
    }

    String getString(String message){
        System.out.println(message);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public int compareTo(Employee o) {
        if(surname.equals(o.surname)){
            return name.compareTo(o.name);
        }
        else{
            return surname.compareTo(o.surname);
        }
    }
}
