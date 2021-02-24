package com.dkit.gd2.johnloane;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Print ArrayList
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<Integer, Student> studentMap = new HashMap<>();
        loadStudentsFromFile(studentMap, "students.txt");
        printStudentMap(studentMap);
        saveStudentsToFile(studentMap);
    }

    private static void saveStudentsToFile(Map<Integer, Student> studentMap)
    {
        try(BufferedWriter studentsFile = new BufferedWriter(new FileWriter("students.txt")))
        {
            for(Map.Entry<Integer, Student> entry : studentMap.entrySet())
            {
                studentsFile.write(entry.getValue().getCaoNumber() + ","+entry.getValue().getName() + "\n");
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void printStudentMap(Map<Integer, Student> studentMap)
    {
        for(Integer key : studentMap.keySet())
        {
            System.out.println(studentMap.get(key));
        }
    }

    private static void loadStudentsFromFile(Map<Integer, Student> studentMap, String fileToLoad)
    {
        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("students.txt"))))
        {
            String input;
            while(studentFile.hasNextLine())
            {
                input = studentFile.nextLine();
                String[] data = input.split(",");
                int caoNumber = Integer.parseInt(data[0]);
                String name = data[1];

                Student readInStudent = new Student(caoNumber, name);
                studentMap.put(caoNumber, readInStudent);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println(fne.getMessage());
        }
    }


}
