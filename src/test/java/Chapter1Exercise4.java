import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Chapter1Exercise4 {
    /**
     * 4.Given an array of File objects,
     * sort it so that the directories come before the files,
     * and within each group, elements are sorted by path name.
     * Use a lambda expression, not a Comparator
     */

    private static final String DIRECTORY_NAME_1 = "DIRECTORY1";
    private static final String DIRECTORY_NAME_2 = "DIRECTORY2";
    private static final String DIRECTORY_NAME_3 = "DIRECTORY3";
    private static final String DIRECTORY_NAME_4 = "DIRECTORY4";
    private static final String DOCUMENT_NAME_1 = "DOCUMENT1";
    private static final String DOCUMENT_NAME_2 = "DOCUMENT2";
    private static final String DOCUMENT_NAME_3 = "DOCUMENT3";
    private static final String DOCUMENT_NAME_4 = "DOCUMENT4";


    @Rule
    public TemporaryFolder rootFolder = new TemporaryFolder();


    @Before
    public void setUp() throws IOException {
        rootFolder.newFolder(DIRECTORY_NAME_1);
        rootFolder.newFile(DOCUMENT_NAME_1);
        rootFolder.newFolder(DIRECTORY_NAME_2);
        rootFolder.newFile(DOCUMENT_NAME_2);
        rootFolder.newFile(DOCUMENT_NAME_3);
        rootFolder.newFile(DOCUMENT_NAME_4);
        rootFolder.newFolder(DIRECTORY_NAME_3);
        rootFolder.newFolder(DIRECTORY_NAME_4);
    }

    private void printArray(File[] arr) {
        for (File i : arr) {
            System.out.println(i.getName());
        }
    }


    @Test
    public void shouldSortFilesByIsDirectory() {
        File[] fls = rootFolder.getRoot().listFiles();
        fls = shuffleArray(fls);
        System.out.println("===========BEFORE==========");
        printArray(fls);
        sortFilesArray(fls);
        System.out.println("===========AFTER==========");
        printArray(fls);

        for (int i = 0; i < 4; i++) {
            assertTrue(fls[i].isDirectory());
        }
        for (int i = 4; i < fls.length; i++) {
            assertFalse(fls[i].isDirectory());
        }

        

    }

    private File[] shuffleArray(File[] fls) {
        List<File> l = Arrays.asList(fls);
        Collections.shuffle(l);
        fls = (File[]) l.toArray();
        return fls;
    }


    private void sortFilesArray(File[] fls) {
        Arrays.sort(fls, (x, y) -> {
            if ((x.isDirectory() && y.isDirectory()) || (!x.isDirectory()&&!y.isDirectory())) {
                return x.getName().compareTo(y.getName());
            } else
                return Boolean.compare(!x.isDirectory(), !y.isDirectory());
        });

    }
}
