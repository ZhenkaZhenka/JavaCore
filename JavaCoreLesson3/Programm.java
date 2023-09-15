package JavaCoreLesson3;

import JavaCoreLesson3.Classes.BaseOfEmployeers;

import java.util.Random;

public class Programm {
    public static void main(String[] args) {
        BaseOfEmployeers b = new BaseOfEmployeers();
        String[] name = {"Atnon", "Gennadii", "Alfred", "Grigorii", "Evgenii", "Ivan", "Oleg", "Artemii"};
        String[] surname = {"Gorohov", "Kapustin", "Morkovkin", "Orgechnii", "Tomatov", "Kabachkov", "Kartoshkin"};
        Random r = new Random();
        for(int i = 10; i > 0; i--){
            int type = r.nextInt(1,3);
            if(type == 1){
                b.add(type, name[r.nextInt(name.length)],
                        surname[r.nextInt(surname.length)], r.nextDouble(100000));
            } else{
                b.add(type, name[r.nextInt(name.length)],
                        surname[r.nextInt(surname.length)], r.nextDouble(500,1000));
            }
        }
        b.add();
        b.add();
        b.print();
        b.sort();
        System.out.println();
        b.print();
    }
}
