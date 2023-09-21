package JavaCoreLesson4;

import JavaCoreLesson4.Exceptions.MyArrayDataException;
import JavaCoreLesson4.Exceptions.MyArraySizeException;

import java.util.Random;
import java.util.Scanner;

public class Array {

    private int sizeX;
    private int sizeY;
    public Object[][] array;

    /**
     * Создание массива необходимого размера.
     * @throws MyArraySizeException Если введенный размер массива не 4х4, появится это исключение
     */
    Array() throws MyArraySizeException{
        sizeY = getInt("Введиет высоту массива: ");
        sizeX = getInt("Введите ширину массива: ");
        if(sizeY != 4 || sizeX != 4){
            throw new MyArraySizeException("Размер массива должен быть 4х4!!!!", sizeX, sizeY);
        }
        array = new Object[sizeY][sizeX];
    }

    /**
     * Ручное заполнение массива
     */
    public void manualFillingArray(){
        Random r = new Random();
        for(int i = 0; i < sizeY; i++){
            for(int j = 0; j < sizeX; j++){
                String message = "Введите символ для ячейки " + '[' + j + ':' + i + ']';
                array[j][i] = getString(message);
            }
        }
    }
    public int sumOfArray(){
        int summ = 0;
        for(int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                    if(isInteger((String)array[i][j])){
                        summ += Integer.parseInt((String)array[i][j]);
                    }
                    else {
                        throw new MyArrayDataException("Одно из значений массива нельзя преобразовать в Integer", j, i);
                    }
            }
        }
        return summ;
    }
    private int getInt(String message){
        System.out.println(message);
        while(true) {
            try {
                Scanner in = new Scanner(System.in);
                int number = in.nextInt();
                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не число, попробуйте еще");
            }
        }
    }
    private String getString(String message){
        System.out.println(message);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * Метод проверки является ли строка целочисленным числом
     * @param value Строка для проверки на Integer
     * @return True - если строка это целочисленное число
     */
    private boolean isInteger(String value){
        int res = 0;
        for(int i = 0; i < value.length(); i++){
            if(Character.isDigit(value.charAt(i))){
                res++;
            }
        }
        if(res == value.length()){
            return true;
        }
        else return false;
    }
}
