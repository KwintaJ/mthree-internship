package model;

public class StudentModel
{
    private int id;
    private String name;
    private int age;

    public StudentModel(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public int getID()
    {
        return id;
    }
}