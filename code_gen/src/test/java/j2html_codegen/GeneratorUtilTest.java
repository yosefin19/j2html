package j2html_codegen;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static j2html_codegen.GeneratorUtil.deleteAllFilesInDir;
import static org.junit.Assert.assertNull;

public class GeneratorUtilTest
{
    @Test
    public void shouldAnswerWithTrue() throws IOException {

        final Path rel1Path = Paths.get("../library/src/main/java/j2html/");
        final Path absPath = rel1Path.toAbsolutePath();
        final String relPath = "tags/attributes/";
        final Path dir = Paths.get(absPath.toString(),relPath);
        deleteAllFilesInDir(dir);
        File directory = new File("Ruta");
        File[] list = directory.listFiles();



        //dummy, just to conform to the default mvn
        //directory layout
        assertNull(list);
    }

    @Test  (expected = NullPointerException.class)
        public void shouldHaveException() throws IOException {


            final Path rel1Path = Paths.get("./library/src/main/java/j2html/");
            final Path absPath = rel1Path.toAbsolutePath();
            final String relPath = "tags/attributes/";
            final Path dir = Paths.get(absPath.toString(), relPath);
            deleteAllFilesInDir(dir);


    }
}
