import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class UserUtilsTest {

    private List<User> userList = Arrays.asList(
            new User("Anna",21,UserUtils.GENDER_FEMALE,true),
            new User("Veronika",30,UserUtils.GENDER_FEMALE,true),
            new User("Alexandra",42,UserUtils.GENDER_FEMALE,false),
            new User("James",17, UserUtils.GENDER_MALE,true),
            null,
            new User("Jack",7,UserUtils.GENDER_MALE,true));

    private  List<User> expectedResult;

    @Test
    public void shouldReturnListOfUsersWithReverseSorting(){
        expectedResult = new ArrayList<>();
        expectedResult.add(new User("Veronika",30,UserUtils.GENDER_FEMALE,true));
        expectedResult.add(new User("James",17,UserUtils.GENDER_MALE,true));
        expectedResult.add(new User("Jack",7,UserUtils.GENDER_MALE,true));
        expectedResult.add(new User("Anna",21,UserUtils.GENDER_FEMALE,true));
        expectedResult.add(new User("Alexandra",42,UserUtils.GENDER_FEMALE,false));

        List<User> actualList = UserUtils.returnListOfUsersWithReverseSorting(userList);
        Assert.assertEquals(expectedResult, actualList);
    }

    @Test
    public void shouldReturnStudentsWithAgeLessThan25(){
        expectedResult = new ArrayList<>();
        expectedResult.add(new User("Anna",21,UserUtils.GENDER_FEMALE,true));
        expectedResult.add(new User("James",17,UserUtils.GENDER_MALE,true));
        expectedResult.add(new User("Jack",7,UserUtils.GENDER_MALE,true));

        List<User> actualResult = UserUtils.returnStudentsWithAgeLessThan25(userList);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldReturnCountOfStudentsWithAgeMoreThan15(){
        Assert.assertEquals(3, UserUtils.returnCountOfStudentsWithAgeMoreThan15(userList));
    }

    @Test
    public void shouldReturnMapOfUsersWithKeyGender(){
        Map<String, List<User>> expectedResult = new HashMap<>();
        List<User> men = new ArrayList<>();
        men.add(new User("James",17,UserUtils.GENDER_MALE,true));
        men.add(new User("Jack",7,UserUtils.GENDER_MALE,true));
        List<User> women = new ArrayList<>();
        women.add(new User("Anna",21,UserUtils.GENDER_FEMALE,true));
        women.add(new User("Veronika",30,UserUtils.GENDER_FEMALE,true));
        women.add(new User("Alexandra",42,UserUtils.GENDER_FEMALE,false));
        expectedResult.put(UserUtils.GENDER_FEMALE, women);
        expectedResult.put(UserUtils.GENDER_MALE, men);

        Map<String, List<User>> actualResult = UserUtils.returnMapOfUsersWithKeyGender(userList);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldReturnAllUsersAsStringWithSeparatingByComma(){
        String expectedResult = "User{name - Anna, age - 21, gender - female, student - true}, User{name - Veronika, age - 30, gender - female, student - true}, User{name - Alexandra, age - 42, gender - female, student - false}, User{name - James, age - 17, gender - male, student - true}, User{name - Jack, age - 7, gender - male, student - true}";
        String actualResult = UserUtils.returnAllUsersAsStringWithSeparatingByComma(userList);
	    Assert.assertEquals(expectedResult,actualResult);
    }

	@Test
	public void shouldReturnListOfUsersWithUpperCaseNameAndGender (){
        expectedResult = new ArrayList<>();
        String expectedFamale = "FEMALE";
        String expectedMale = "MALE";
        expectedResult.add(new User("ANNA",21,expectedFamale,true));
        expectedResult.add( new User("VERONIKA",30,expectedFamale,true));
        expectedResult.add(new User("ALEXANDRA",42,expectedFamale,false));
        expectedResult.add(new User("JAMES",17, expectedMale,true));
        expectedResult.add(new User("JACK",7,expectedMale,true));

        List<User> actualResult = UserUtils.returnListOfUsersWithUpperCaseNameAndGender(userList);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldReturnListOfUserReductionsWithUpperCaseNameAndGender (){
        List <UserReduction> expectedResult = new ArrayList<>();
        String expectedFamale = "FEMALE";
        String expectedMale = "MALE";
        expectedResult.add(new UserReduction("ANNA",expectedFamale));
        expectedResult.add( new UserReduction("VERONIKA",expectedFamale));
        expectedResult.add(new UserReduction("ALEXANDRA",expectedFamale));
        expectedResult.add(new UserReduction("JAMES", expectedMale));
        expectedResult.add(new UserReduction("JACK",expectedMale));

        List<UserReduction> actualResult = UserUtils.returnListOfUserReductionsWithUpperCaseNameAndGender(userList);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void shouldReturnMapUsersGroupedByStudentContainingMapByGenders(){
        Map<String, List<User>> studentsResult = new HashMap<>();
        List<User> men = new ArrayList<>();
        men.add(new User("James",17,UserUtils.GENDER_MALE,true));
        men.add(new User("Jack",7,UserUtils.GENDER_MALE,true));
        List<User> women = new ArrayList<>();
        women.add(new User("Anna",21,UserUtils.GENDER_FEMALE,true));
        women.add(new User("Veronika",30,UserUtils.GENDER_FEMALE,true));
        studentsResult.put(UserUtils.GENDER_MALE, men);
        studentsResult.put(UserUtils.GENDER_FEMALE, women);

        Map<String, List<User>> notStudentsResult = new HashMap<>();
        men = new ArrayList<>();
        women = new ArrayList<>();
        women.add(new User("Alexandra",42,UserUtils.GENDER_FEMALE,false));
        notStudentsResult.put(UserUtils.GENDER_FEMALE, women);

        Map<Boolean, Map> expectedResult = new HashMap<>();
        expectedResult.put(true,studentsResult);
        expectedResult.put(false,notStudentsResult);

        Map<Boolean, Map<String, List<User>>> actualResult =
                UserUtils.returnMapUsersGroupedByStudentContainingMapByGenders(userList);
        Assert.assertEquals(expectedResult,actualResult);
    }

}
