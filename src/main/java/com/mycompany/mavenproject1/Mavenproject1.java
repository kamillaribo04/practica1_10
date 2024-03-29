
package com.mycompany.mavenproject1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
   
       System.out.println("Practical task 1.10, Student Sharapova Kamilla, RIBO-04-22, Variant 5");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к каталогу для сканирования: ");
        String directoryPath = scanner.nextLine();
        ArrayList<String> results = new ArrayList<>();
        ArrayList<String> results1 = new ArrayList<>();
        searchFiles(Paths.get(directoryPath), results, results1);
        Collections.sort(results);
        Collections.sort(results1);
            System.out.println("Scanning " + directoryPath);
            for (String result1 : results1) {
                System.out.println(result1);
    }
            for (String result : results) {
                System.out.println(result);
    }
            
                
    }
    private static void searchFiles(Path path, ArrayList<String> results, ArrayList<String> results1) {
        File folder = path.toFile();
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    results1.add(file.getPath() + "   Folder");
                    searchFiles(file.toPath(), results, results1);

                } else if (file.isFile()) {
                    try {
                        long size = Files.size(file.toPath());
                        results.add(file.getPath() + "   " + size);
                    } catch (IOException ex) {
                        System.out.println("Ошибка при получении размера файла: " + ex.getMessage());
                    }
                }
            }
        }

}}
    