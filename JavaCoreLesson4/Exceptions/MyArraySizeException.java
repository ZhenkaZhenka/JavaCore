package JavaCoreLesson4.Exceptions;

public class MyArraySizeException extends RuntimeException{
    private int sizeX;
    private int sizeY;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public MyArraySizeException(String message, int sizeX, int sizeY){
        super(message);
        this.sizeY = sizeY;
        this.sizeX = sizeX;
    }
}
