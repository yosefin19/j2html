package j2html_codegen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static j2html_codegen.model.AttributesList.getCustomAttributesForHtmlTag;
import static org.junit.Assert.assertEquals;

public class AttributesListTest {

    @Test
    public void testGetCustomAttributesForHtmlTag(){
        final List<String> expectedAttrs = new ArrayList<>();
        expectedAttrs.add("autofocus");
        expectedAttrs.add("disabled");
        expectedAttrs.add("form");
        expectedAttrs.add("formaction");
        expectedAttrs.add("name");
        expectedAttrs.add("type");
        expectedAttrs.add("value");

        final List<String> resultAttrs = getCustomAttributesForHtmlTag("button");
        assertEquals(expectedAttrs,resultAttrs);
        assertEquals(resultAttrs.size(),expectedAttrs.size());
        int i=0;
        while(i<resultAttrs.size()){
            assertEquals(resultAttrs.get(i),expectedAttrs.get(i));
            i++;
        }







    }







}
