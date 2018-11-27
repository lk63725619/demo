package com.home.reflection;

public class People
{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void isPrivateMethod(String name)
    {
        System.out.println(" is private parent "+name+"  method ");
    }

    public void isPublicMethod()
    {
        System.out.println(" is public parent method");
    }

}

class Women extends People
{
    public void isWomenMethod(String name)
    {
        System.out.println(" is public women "+ name +" method");
    }
}