import java.util.Arrays;

public class Java8ExercicesApplication {


public void sortAlphabetically(String[] strings){
    Arrays.sort(strings, (o1, o2) -> o1.length()-o2.length());
}


    public static void main(String[] args) {
        String[] strings = {"test", "kot", "pies", "szczur", "malpa", "nosorozec", "wilkolak", "jez", "kolczatka", "kangur"};

        Java8ExercicesApplication java8ExercicesApplication = new Java8ExercicesApplication();
        java8ExercicesApplication.sortAlphabetically(strings);
        System.out.println(Arrays.asList(strings));
    }


}
