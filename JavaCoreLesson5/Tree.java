package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("./src/main/java"), "", true);

    }

    /**
     * Метод печатает все файлы и директории находящиеся по указаному пути
     * @param file - начальный путь
     * @param indent - символ-разделитель
     * @param isLast - маркер последнего элемента в поддиректории
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subCounter = 0;
        for (int i = 0; i < files.length; i++){
            subCounter++;
            print(files[i], indent, subCounter == files.length);
        }

    }

}