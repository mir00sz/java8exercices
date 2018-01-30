import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class Chapter1Exercise3 {
    private File[] folders;
    private File[] files;

    @Rule
    public TemporaryFolder rootFolder = new TemporaryFolder();


    @Before
    public void setUp() throws IOException {
        folders = new File[]{new File("testFolder1"), new File("testFolder2")};
        files = new File[]{new File("testFile1.test"), new File("testFile2.test")};
        for (File folder : folders) {
            rootFolder.newFolder(folder.getName());
        }
        for (File file : files) {
            rootFolder.newFile(file.getName());
        }
    }


    @Test
    public void shouldReturnFilesWithGivenExtension() {
        String[] filesWithGivenExtension = listFilesWithGivenExtension(rootFolder, "test");
        List<String> fileNames = Arrays.asList(filesWithGivenExtension);
        assertTrue("filesWithGivenExtension.length =  " + filesWithGivenExtension.length + " files.length = " + files.length, filesWithGivenExtension.length == files.length);
        for (String fileName : filesWithGivenExtension) {
            assertTrue(fileNames.contains(fileName));
        }

    }

    private String[] listFilesWithGivenExtension(TemporaryFolder rootFolder, String test) {
        return rootFolder.getRoot().list((file, name) ->
                name.endsWith(test));
    }

}
