package JavaCoreLesson4;

import JavaCoreLesson4.Exceptions.MyArrayDataException;
import JavaCoreLesson4.Exceptions.MyArraySizeException;

public class Programm {
    public static void main(String[] args) {
        while (true) {
            try {
                Array newAr = new Array();
                newAr.manualFillingArray();
                int res = newAr.sumOfArray();
                System.out.println(res);
                break;
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
