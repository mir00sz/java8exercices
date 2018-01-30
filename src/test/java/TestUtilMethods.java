import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestUtilMethods {


    public static List<String> getFileNames(File[] listOfDirectories) {
        List<String> result = new ArrayList<>();
        for (File f : listOfDirectories) {
            result.add(f.getName());
        }
        return result;
    }
}
