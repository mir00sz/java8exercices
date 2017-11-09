import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

public class LambdasPart1 {

    private final String[] strings = {"wilkolak", "test", "kot", "pies", "szczur", "malpa", "nosorozec", "jez", "kolczatka", "kangur"};
    private static final Logger LOGGER = Logger.getLogger("Tests");

    /*
           Exercice firs from http://www.java-programming.info/tutorial/pdf/java/exercises/exercises-lambdas-1.pdf
     */
    @Test
    public void sortByWordLength() {

        Arrays.sort(strings, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (o1, o2) -> o1.charAt(0) - o2.charAt(0));
        System.out.println(Arrays.asList(strings));
    }

}
