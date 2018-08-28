package jdbc;

public class User {
    private int id;
    private String name;
    private String password;
    private Integer age;
    private String email;

    public User() {
    }

    public User(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password) {
        this(name, password);
        this.id = id;
    }

    public User(int id, String name, String password, Integer age, String email) {
        this(id, name, password);
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
