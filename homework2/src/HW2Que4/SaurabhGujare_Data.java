package HW2Que4;

public class SaurabhGujare_Data {

    private int age;
    private String name;

    public SaurabhGujare_Data() {
    }

    public SaurabhGujare_Data(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SaurabhGujare_Data{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
