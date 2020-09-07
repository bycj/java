package xinan.demo.classloader;

/**
 * @author xinan
 * @date 2020/09/05
 */

public class Person
{
    private String name;

    public Person()
    {

    }

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return "I am a person, my name is " + name;
    }
}
