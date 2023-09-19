package com.pockocmoc;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class CopyFiles {


    static void copyFiles(String sourceDir, String targetDir,
                          String extension) {
        File source = new File(sourceDir);

        if (!source.exists()) {
            System.out.println("Папка " + sourceDir + " не существует.");
            return;
        }
        if (!source.isDirectory()) {
            System.out.println(sourceDir + " не является папкой.");
            return;
        }
        File target = new File(targetDir);
        if (!target.exists()) {
            target.mkdirs();
        }
        if (!target.isDirectory()) {
            System.out.println(targetDir + " не является папкой.");
            return;
        }

        for (File f : Objects.requireNonNull(source.listFiles())) {
            if (f.isDirectory()) {
                copyFiles(f.getAbsolutePath(),
                        target.getAbsolutePath(), extension);
            } else if (f.getName().endsWith(extension)) {
                System.out.println("Copying " + f.getName());
                File copy = new File(target, f.getName());
                try {
                    if (copy.createNewFile()) {
                        System.out.println("Файл " + f.getName() + " создан.");
                    } else {
                        System.out.println("Ошибка при создании файла " +
                                f.getName());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}



