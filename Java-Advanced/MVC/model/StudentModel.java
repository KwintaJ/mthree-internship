package model;

// model - representation of a student
public class StudentModel
{
    // information about the student
    private int id;
    private String name;
    private int age;

    // constructor
    public StudentModel(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // setters and getters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    // no setID()
    // ID will not change

    public int getID()
    {
        return id;
    }
}