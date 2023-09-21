package JavaCoreLesson4.Exceptions;

public class MyArrayDataException extends RuntimeException{
    int x;
    int y;
    public MyArrayDataException(String message, int x, int y){
        super(message);
        this.x = x;
        this.y = y;
    }
}
