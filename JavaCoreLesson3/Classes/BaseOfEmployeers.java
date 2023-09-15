package JavaCoreLesson3.Classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BaseOfEmployeers implements Iterable<Employee>{
    public Employee[] base = {};

    /**
     * Добавление работника в базу
     * @param type - 1 - Worker, 2 - Freelancer
     * @param name - имя работника
     * @param surname - фамилия работника
     * @param number - Оклад или тарифная ставка работника
     */
    public void add(int type, String name, String surname, double number){
        enlargeArray();
        if(type == 1) {
            base[base.length - 1] = new Worker(name, surname, number);
        } else if(type == 2) {
            base[base.length - 1] = new Freelancer(name, surname, number);
        }
        else{
            System.out.println("Не корректный тип работника");
        }
    }

    /**
     * Добавление работника без указания оклада или тарифной ставки
     * @param type - 1 - Worker, 2 - Freelancer
     * @param name - имя работника
     * @param surname - фамилия работника
     */
    public void add(int type, String name, String surname){
        enlargeArray();
        if(type == 1) {
            base[base.length - 1] = new Worker(name, surname);
        } else if(type == 2) {
            base[base.length - 1] = new Freelancer(name, surname);
        }
        else{
            System.out.println("Не корректный тип работника");
        }
    }

    /**
     * Создание сотрудника с вводом его данных из консоли
     * @param type - тип сотрудника
     */
    public void add(int type){
        enlargeArray();
        if(type == 1) {
            base[base.length - 1] = new Worker();
        } else if(type == 2) {
            base[base.length - 1] = new Freelancer();
        }
        else{
            System.out.println("Не корректный тип работника");
        }
    }
    public void add(){
        enlargeArray();
        int type = getType("Введите типа сотрудника:\n" +
                "1 - Постоянный работник\n" +
                "2 - Наемный рабочий(Freelancer)\n");
        if(type == 1) {
            base[base.length - 1] = new Worker();
        } else{
            base[base.length - 1] = new Freelancer();
        }
    }

    public void print(){
        Iterator<Employee> i = iterator();
        while(i.hasNext()){
            System.out.println(i.next().toString());
        }
    }
    private int getType(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                int number = in.nextInt();
                if (number != 1 && number != 2) {
                    throw new RuntimeException();
                }
                return number;
            } catch (RuntimeException e) {
                System.out.println("Не корректный тип работника. Попробуйте заного.");
            } catch (Exception e) {
                System.out.println("Вы ввели не число, попробуйте еще");
            }
        }
    }

    private void enlargeArray(){
        Employee[] newAr = base;
        base = new Employee[newAr.length + 1];
        for(int i = 0; i < newAr.length; i++){
            base[i] = newAr[i];
        }
    }

    @Override
    public Iterator<Employee> iterator() {
        return Arrays.stream(base).iterator();
    }

    public <Employee extends Comparable<Employee>> void sort(){
        int counter = 1;
        while(counter > 0){
            counter = 0;
            for(int i = 0; i < base.length - 1; i++){
                if(base[i].compareTo(base[i+1]) > 0){
                    swap(base, i, i+1);
                    counter++;
                }
            }
        }
    }
    private void swap(Employee[] ar, int i1, int i2){
        Employee temp = ar[i1];
        ar[i1] = ar[i2];
        ar[i2] = temp;
    }
}
