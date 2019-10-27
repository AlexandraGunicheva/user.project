import java.util.*;
import java.util.stream.Collectors;

class UserUtils {

    static final String GENDER_FEMALE = "female";
    static final String GENDER_MALE = "male";

    //A Map<Boolean, Map<String, List<User>>>, where key=student, second map key = gender
    static Map<Boolean, Map<String, List<User>>> returnMapUsersGroupedByStudentContainingMapByGenders(List<User> userList) {
        Map<Boolean, List<User>> usersGroupedByStudent = userList.stream()
                .collect(Collectors.groupingBy(User::isStudent));

        Map<Boolean, Map<String, List<User>>> result = new HashMap<>();

        usersGroupedByStudent.forEach((key, value) -> result.put(key, value.stream()
                        .collect(Collectors.groupingBy(User::getGender))
        ));

        return result;
    }

    //Return UserReduction list where name and gender are uppercase.
    static List<UserReduction> returnListOfUserReductionsWithUpperCaseNameAndGender(List<User> userList) {
        return userList.stream()
                .map((u) -> new UserReduction(u.getName().toUpperCase(), u.getGender().toUpperCase()))
                .collect(Collectors.toList());
    }

    //Return a list where name and gender are uppercase.
    static List<User> returnListOfUsersWithUpperCaseNameAndGender(List<User> userList) {
        return userList.stream()
                .map((u) -> {
                    u.setName(u.getName().toUpperCase());
                    u.setGender(u.getGender().toUpperCase());
                    return u;
                })
                .collect(Collectors.toList());
    }

    // Return a String with users, each User should be separated by the comma
    static String returnAllUsersAsStringWithSeparatingByComma(List<User> userList) {
        return userList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    // Return a Map<String, List<User>>, where key=gender
    static Map<String, List<User>> returnMapOfUsersWithKeyGender(List<User> userList) {
        return userList.stream()
                .collect(Collectors.groupingBy(User::getGender));
    }

    // Return count of students with age>15
    static long returnCountOfStudentsWithAgeMoreThan15(List<User> userList) {
        return userList.stream()
                .filter((u) -> u.isStudent() && u.getAge() > 15)
                .count();
    }

    //Return list of students with age<25
    static List<User> returnStudentsWithAgeLessThan25(List<User> userList) {
        return userList.stream()
                .filter((u) -> u.isStudent() && u.getAge() < 25)
                .collect(Collectors.toList());
    }

    // Sorted list by names from Z to A
    static List<User> returnListOfUsersWithReverseSorting(List<User> userList) {
        return userList.stream()
                .sorted(Comparator.comparing(User::getName).reversed())
                .collect(Collectors.toList());
    }

}
