package j2html.tags;

import org.junit.Test;

import static j2html.TagCreator.footer;
import static j2html.TagCreator.p;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConteinerTagTest {

    @Test
    public void with_Assert() {
        String test = footer().with(p("Simple with!")).render();
        String expectedResult = "<footer><p>Simple with!</p></footer>";
        assertThat(test, is((expectedResult)));
    }
    @Test
    public void withCond_Assert(){
        String test = footer().condWith(1 == 1, p("Conditional with!")).render();
        String expectedResult = "<footer><p>Conditional with!</p></footer>";
        assertThat(test, is((expectedResult)));

    }
    @Test
    public void withCond_FalseCondition(){
        String test = footer().condWith(1 == 3, p("Conditional with!")).render();
        String expectedResult = "<footer></footer>";
        assertThat(test, is((expectedResult)));

    }
    @Test
    public void withCond_WithoutDomChild(){
        String test = footer().condWith(1 == 1).render();
        String expectedResult = "<footer></footer>";
        assertThat(test, is((expectedResult)));

    }

    @Test
    public void withCond_WithoutDomChildFalseCondition(){
        String test = footer().condWith(1 == 3).render();
        String expectedResult = "<footer></footer>";
        assertThat(test, is((expectedResult)));

    }
    @Test
    public void with_WithoutDomChild(){
        String test = footer().with().render();
        String expectedResult = "<footer></footer>";
        assertThat(test, is((expectedResult)));

    }

    @Test (expected = RuntimeException.class)
    public void withCond_WithHimselfAsChild(){

            String test = footer().with(footer()).render();
            System.out.println(test);


    }

}
