package com.pockocmoc;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;


public class CopyFiles {


    static String copyFiles(String sourceDir, String targetDir,
                            String extension, JTextArea resultArea) {
        File source = new File(sourceDir);

        if (!source.exists()) {
            resultArea.append("Папка " + sourceDir + " не существует.\n");
            return sourceDir;
        }
        if (!source.isDirectory()) {
            resultArea.append(sourceDir + " не является папкой.\n");
            return sourceDir;
        }
        File target = new File(targetDir);
        if (!target.exists()) {
            target.mkdirs();
        }
        if (!target.isDirectory()) {
            resultArea.append(targetDir + " не является папкой.\n");
            return sourceDir;
        }

        for (File f : Objects.requireNonNull(source.listFiles())) {
            if (f.isDirectory()) {
                copyFiles(f.getAbsolutePath(),
                        target.getAbsolutePath(), extension, resultArea);
            } else if (f.getName().endsWith(extension)) {
                resultArea.append("Копирование файла " + f.getName() + "\n");
                File copy = new File(target, f.getName());
                try {
                    if (copy.createNewFile()) {
                        resultArea.append("Файл " + f.getName() + " создан.\n");
                        FileInputStream inputStream = new FileInputStream(f);
                        FileOutputStream outputStream = new FileOutputStream(copy);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, length);
                        }
                        inputStream.close();
                        outputStream.close();
                    } else {
                        resultArea.append("Ошибка при создании файла " +
                                f.getName() + "\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sourceDir;
    }
}



