import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String gender;
    private boolean isStudent;

    public User(String name, int age, String gender, boolean isStudent){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isStudent = isStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                isStudent == user.isStudent &&
                Objects.equals(name, user.name) &&
                Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, isStudent);
    }

    @Override
    public String toString(){
        return "User{" +
                "name - " + name +
                ", age - " + age +
                ", gender - " + gender +
                ", student - " + isStudent +
                "}";
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

}
