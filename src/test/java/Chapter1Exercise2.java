import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Chapter1Exercise2 {

    private File[] folders;

    @Rule
    public TemporaryFolder rootFolder = new TemporaryFolder();


    @Before
    public void setUp() throws IOException {
        folders = new File[]{new File("testFolder1"), new File("testFolder2")};
        File[] files = new File[]{new File("testFile1"), new File("testFile2")};
        for (File folder : folders) {
            rootFolder.newFolder(folder.getName());
        }
        for (File file : files) {
            rootFolder.newFile(file.getName());
        }
    }

    @Test
    public void testLambdaExpression() {
        File[] listOfDirectories = listFilesWithLambdaExpression(rootFolder.getRoot());
        List<String> fileNames = getFileNames(listOfDirectories);
        assertTrue(listOfDirectories.length == folders.length);
        for (File f : folders) {
            assertTrue(fileNames.contains(f.getName()));
        }
    }


    @Test
    public void testMethodExpression() {
        File[] listOfDirectories = listFilesWithMethodExpression(rootFolder.getRoot());
        List<String> fileNames = getFileNames(listOfDirectories);
        assertTrue(listOfDirectories.length == folders.length);
        for (File f : folders) {
            assertTrue(fileNames.contains(f.getName()));
        }
    }


    private List<String> getFileNames(File[] listOfDirectories) {
        List<String> result = new ArrayList<>();
        for (File f : listOfDirectories) {
            result.add(f.getName());
        }
        return result;
    }

    private File[] listFilesWithLambdaExpression(File parent) {
        return parent.listFiles(f -> f.isDirectory());
    }


    private File[] listFilesWithMethodExpression(File parent) {
        return parent.listFiles(File::isDirectory);
    }

}
