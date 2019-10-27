import java.util.Objects;

public class UserReduction {
    private String name;
    private String gender;

    public UserReduction(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "UserReduction{" +
                "name - " + name +
                ", gender - " + gender +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserReduction)) return false;
        UserReduction that = (UserReduction) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
