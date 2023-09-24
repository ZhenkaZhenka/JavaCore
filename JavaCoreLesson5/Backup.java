package JavaCoreLesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;


public class Backup {
    public static void main(String[] args) throws IOException {
        LocalDate ld = LocalDate.now();
        Date dt = new Date();
        String sourceDirectory = "./src/main";
        String backupDirectory = "./backup" + ld.now() + "_" + dt.getHours() + "_" + dt.getMinutes();

        createBackup(sourceDirectory, backupDirectory);
    }

    public static void createBackup(String sourceDirectory, String backupDirectory) throws IOException {
        // Создаем папку для резервных копий, если ее нет
        File backupDir = new File(backupDirectory);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Получаем список файлов в директории
        File sourceDir = new File(sourceDirectory);
        File[] files = sourceDir.listFiles();

        // Копируем содержимое необходимой директории в папку с резервными копиями
        for (int i = 0; i < files.length; i++) {
            backUp(backupDir,sourceDir, files[i]);
        }
    }

    private static void backUp(File backupDir, File source, File nameOfDir) throws IOException {
        // Создаем новый массив с файлами
        File sourceDir = new File(source.toPath() + "/" + nameOfDir.getName());
        File[] files = sourceDir.listFiles();
        if(files == null) {
            return;
        }
        for (int j = 0; j < files.length; j++) {
            if (files[j].isDirectory()) {
                // Создаем новый путь для backup, чтоб сохранить структуру сохраняемых директорий
                File pathName = new File(backupDir + "/" + files[j].getName());
                // Копирование директории и переход внутрь нее для копирования файлов внутри нее
                Files.copy(files[j].toPath(), pathName.toPath(), StandardCopyOption.REPLACE_EXISTING);
                backUp(pathName, sourceDir, files[j]);
            } else if (files[j].isFile()) {
                Files.copy(files[j].toPath(),
                        new File(backupDir.toPath() + "/" + files[j].getName()).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}