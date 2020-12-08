package j2html_codegen;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static j2html_codegen.generators.SpecializedTagClassCodeGenerator.*;
import static org.junit.Assert.assertEquals;


public class SpecializedTagClassCodeGeneratorTest {

    @Test
    public void testClassNameFromTag(){
        String expected =  "AreaTag";
        String value = classNameFromTag("area");
        assertEquals(value,expected);
    }

    @Test
    public void testMakePath(){
        Path expected = Paths.get("/home/estudiante/IdeaProjects/j2html/./library/src/main/java/j2html/tags/specialized/generated/VideoTag.java");
        Path absPath = Paths.get("/home/estudiante/IdeaProjects/j2html/./library/src/main/java/j2html");
        Path actual = makePath(absPath, "video");
        assertEquals(actual,expected);
    }

    @Test
    public void testGetClassTemplate(){
        String expected = "package j2html.tags.specialized.generated;\n" +
            "\n" +
            "import j2html.tags.ContainerTag;\n" +
            "import j2html.tags.attributes.*;\n" +
            "\n" +
            "public final class RpTag extends ContainerTag<RpTag>  {\n" +
            "public RpTag() {super(\"rp\");}\n" +
            "}\n";

        final List<String> interfaceNames = getInterfaceNamesForTag("rp");
        List<String> imports =  Arrays.asList("j2html.tags.ContainerTag","j2html.tags.attributes.*");
        String actual = getClassTemplate("RpTag", Optional.of("ContainerTag<RpTag>"),imports,"rp",interfaceNames);
        assertEquals(expected,actual);

    }

}
