package j2html.tags;

import org.junit.Test;

import static j2html.TagCreator.div;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TagWithTest {
    @Test
    public void tag_withClasess(){
        String expected = "<div class=\"rojo banner tipsPage\"></div>";
        String actual = div().withClasses("rojo", "banner", "tipsPage").render();
        assertThat(actual, is(expected));
    }

}
