package j2html.attributes;

import org.junit.Test;

import static j2html.TagCreator.div;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class shortFormFromAttrsStringTest {
    @Test
    public void shortForm_justId() {
        String expected = "<div id=\"10\"></div>";
        String actual = div(Attr.shortFormFromAttrsString("#10")).render();
        assertThat(actual, is(expected));

    }

    @Test
    public void shortForm() {
        String expected = "<div id=\"02\" class=\"cajaDeDatos\"></div>";
        String actual = div(Attr.shortFormFromAttrsString("#02.cajaDeDatos")).render();

        assertThat(actual, is(expected));

    }

    @Test
    public void shortForm_Classes() {
        String expected = "<div class=\"texto rojo negrita\"></div>";
        String actual = div(Attr.shortFormFromAttrsString(".texto.rojo.negrita")).render();

        assertThat(actual, is(expected));

    }

    @Test(expected = IllegalArgumentException.class)
    public void addTo_stringWithoutDot() {
        div(Attr.shortFormFromAttrsString("texto")).render();

    }
    @Test(expected = IllegalArgumentException.class)
    public void shortForm_withTwoId() {
        div(Attr.shortFormFromAttrsString("#4#10")).render();

    }
    @Test(expected = IllegalArgumentException.class)
    public void shortForm_IdWithoutNumeral() {
        div(Attr.shortFormFromAttrsString("4")).render();

    }


}
