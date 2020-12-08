package j2html_codegen;

import j2html_codegen.model.AttrD;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static j2html_codegen.generators.AttributeInterfaceCodeGenerator.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class AttributeInterfaceCodeGeneratorTest{

    @Test
    public void  testInterfaceNameFromAttribute() throws Exception {
        String expected = "IAccept";
        String actual = interfaceNameFromAttribute("accept");
        assertThat(actual, is(expected));
    }

    @Test
    public void testMakePath() throws Exception {
        Path expected = Paths.get("/home/estudiante/IdeaProjects/j2html/./library/src/main/java/j2html/tags/attributes/IAccept.java");
        Path absPath = Paths.get("/home/estudiante/IdeaProjects/j2html/./library/src/main/java/j2html");
        Path actual = makePath("accept", absPath);
        assertThat(actual, is(expected));
    }

    @Test
    public void  testAddAttributeNoArg() throws Exception {
        String expected = "get().attr(\""+"autofocus\""+");\n";
        StringBuilder sb = new StringBuilder();
        addAttributeNoArg(sb, "autofocus");
        String actual = (sb).toString();
        assertThat(actual, is(expected));
    }

    @Test
    public void  testAddAttributeNoArgAutocomplete() throws Exception {
        String expected = "get().attr("+"\"autocomplete\",\"on\");\n";
        StringBuilder sb = new StringBuilder();
        addAttributeNoArg(sb, "autocomplete");
        String actual = (sb).toString();
        assertThat(actual, is(expected));
    }

    @Test
    public void   testWriteAttributeMethodCondHasArgument() throws Exception {
        String expected = "default T withCondAccept(final boolean enable, final String accept_) {if (enable){\n" +
            "get().attr(\"accept\", accept_);\n" +
            "}\n" +
            "return get();\n" +
            "}\n";
        StringBuilder sb = new StringBuilder();
        AttrD attr = new AttrD("accept",true);
       writeAttributeMethodCond("Accept", attr , sb, "accept", "accept_");
        String actual = (sb).toString();
        assertThat(actual, is(expected));
    }

    @Test
    public void   testWriteAttributeMethodCond() throws Exception {
        String expected = "default T withCondAsync(final boolean enable) {if (enable){\n" +
            "get().attr(\"async\");\n" +
            "}\n" +
            "return get();\n" +
            "}\n";
        StringBuilder sb = new StringBuilder();
        AttrD attr = new AttrD("async",false);
        writeAttributeMethodCond("Async", attr , sb, "async", "async_");
        String actual = (sb).toString();
        assertThat(actual, is(expected));
    }
    @Test
    public void   testGetInterfaceTemplate() throws Exception {
        String expected = "package j2html.tags.attributes;\n\n" +
            "import j2html.tags.Tag;\n" +
            "import j2html.tags.IInstance;\n\n" +
            "public interface IAccept<T extends " +
            "Tag> extends IInstance<T>  {\n" +
            "default T withAccept(final String " +
            "accept_) {get().attr(\"accept\", accept_);\n" +
        "return get();\n" +
        "}\n" +
            "default T withCondAccept(final boolean enable, final String accept_) {if (enable){\n" +
            "get().attr(\"accept\", accept_);\n" +
        "}\n" +
        "return get();\n" +
        "}\n" +
        "}\n";

        StringBuilder sb = new StringBuilder();
        AttrD attr = new AttrD("accept",true, "accept");
        List<String> imports =  Arrays.asList("j2html.tags.Tag","j2html.tags.IInstance");

       String actual = getInterfaceTemplate("IAccept<T extends Tag>", java.util.Optional.of("IInstance<T>"), imports, "Accept", attr );
       assertThat(actual, is(expected));
    }

    @Test
    public void testWriteAttributeMethod(){

        StringBuilder sb = new StringBuilder("package j2html.tags.attributes;\n" +
            "import j2html.tags.Tag;\n" +
            "import j2html.tags.IInstance;\n" +
            "public interface IOnhashchange<T extends Tag> extends IInstance<T>  {\n");

        String expected = "package j2html.tags.attributes;\n" +
            "import j2html.tags.Tag;\n" +
            "import j2html.tags.IInstance;\n" +
            "public interface IOnhashchange<T extends Tag> extends IInstance<T>  {\n" +
            "default T withOnhashchange(final String onhashchange_) {" +
            "get().attr(\"onhashchange\", onhashchange_);\n" +
            "return get();\n" +
            "}\n";
        final String interfaceNameSimple = "Onhashchange";
        final String attrName = interfaceNameSimple.toLowerCase();
        final String paramName = attrName+"_";
        final String[] tags = new String[]{"body"};
        AttrD attrD = new AttrD("onhashchange",
            true,
            tags);
        writeAttributeMethod(interfaceNameSimple,attrD,sb,attrName,paramName);
        assertEquals(expected,sb.toString());
    }

}
