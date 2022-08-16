package base.java.ref;

/**
 * @ClassName User
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-12 15:54
 * @Version 1.0
 */
public class User {

    private String name = "init";
    private int age;
    public User() {}
    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        Class<? extends User> aClass = new User().getClass();
        System.out.println(userClass);
        System.out.println(aClass);

    }
}
