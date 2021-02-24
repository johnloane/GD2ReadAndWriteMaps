package com.dkit.gd2.johnloane;

public class Student
{
    private int caoNumber;
    private String name;

    public Student(int caoNumber, String name)
    {
        this.caoNumber = caoNumber;
        this.name = name;
    }

    public Student(Student student)
    {
        this.caoNumber = student.caoNumber;
        this.name = student.name;
    }

    public int getCaoNumber()
    {
        return caoNumber;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "caoNumber=" + caoNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
