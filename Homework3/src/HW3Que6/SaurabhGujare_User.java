package HW3Que6;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class SaurabhGujare_User implements Comparable<SaurabhGujare_User> {
    private String name;
    private int id;
    private Date birth;

    public SaurabhGujare_User(String name, int id, Date birth) {
        this.name = name;
        this.id = id;
        this.birth = birth;
    }

    @Override
    public int compareTo(SaurabhGujare_User o) {
        return this.id- o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaurabhGujare_User that = (SaurabhGujare_User) o;
        return id == that.id &&
                name.equals(that.name) &&
                birth.equals(that.birth);
    }

    @Override
    public int hashCode() {
        int res = 0;
        res = 31*res + id;
        res = 31*res + (name !=null ? name.hashCode() : 0);
        res = 31*res + (birth !=null ? birth.hashCode() : 0);
        return res;
    }
    public static void main(String[] args) {
        SaurabhGujare_User user1 = new SaurabhGujare_User("ABC", 25, new Date(2/1/2018));
        SaurabhGujare_User user2 = new SaurabhGujare_User("ABC", 25, new Date(2/1/2018));
        SaurabhGujare_User user3 = new SaurabhGujare_User("ABC", 25, new Date(2/2/2018));
        SaurabhGujare_User user4 = new SaurabhGujare_User("ABC", 25, new Date(2/1/2018));
        SaurabhGujare_User user5 = new SaurabhGujare_User("ABC", 22, new Date(1/1/2018));
        SaurabhGujare_User user6;
        SaurabhGujare_User user7 = new SaurabhGujare_User("XYZ", 21, new Date(2/1/2018));
        user6 = user4;
        System.out.println("User1 hashCode()"+user1.hashCode());
        System.out.println("USer2 hashCode()" +user2.hashCode());
        System.out.println("USer5 hashCode()" +user6.hashCode());
        System.out.println("Test compareTo(): " +(user1.compareTo(user5)));
        System.out.println("Test compareTo(): " +(user1.compareTo(user2)));
        System.out.println("Test equals(): "+(user1.equals(user2)));
        System.out.println("Test equals(): "+(user4.equals(user6)));
        System.out.println("Test equals(): "+(user1.equals(user5)));
    }


}
