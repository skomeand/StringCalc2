import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by andreas on 1/22/14.
 */
public class StringCalcTest
{
    @Test
    public void shouldAddAnyAmoutOfNumbers() throws Exception
    {
        assertEquals(StringCalc.add(""), 0);
        assertEquals(StringCalc.add("1"), 1);
        assertEquals(StringCalc.add("1,2"), 3);
        assertEquals(StringCalc.add("1,2,3"), 6);
    }

    @Test
    public void shouldHandleNewLinesBetweenNumbers() throws Exception
    {
        assertEquals(StringCalc.add("1\n2,3"), 6);
    }

    @Test
    public void shouldAllowDifferentDelims() throws Exception
    {
        assertEquals(StringCalc.add("//;\n1;4"), 5);
        assertEquals(StringCalc.add("//x\n1x5"), 6);
    }

    @Test
    public void shouldNotAllowNegativesNumbers() throws Exception
    {
        try{
            StringCalc.add("-1,-3");
            fail("Should throw exception");
        }
        catch (Exception e){
            assertThat(e.getMessage(), containsString("negatives not allowed"));
            assertThat(e.getMessage(), containsString("-1"));
            assertThat(e.getMessage(), containsString("-3"));
        }
    }
}
