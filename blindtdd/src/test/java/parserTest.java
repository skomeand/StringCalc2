import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created by andreas on 2/5/14.
 */
public class parserTest {
    
    
    Parser classe;

    private String string = "<? xml version=\"1.0\" ?>" +
            "<bulk id=\"$ID\"/>";


    @Before
    public  void setup() {
        classe = new Parser();
    }
    
    @Test
    public void testId() {
        try {

            assertEquals("1234", classe.findId(string.replace("$ID", "1234")));
            assertEquals("12345", classe.findId(string.replace("$ID", "12345")));
            assertEquals("1", classe.findId(string.replace("$ID", "1")));

        } catch (Exception e){
        }
    }

    @Test
    public void testValidIds() throws Exception{

        assertEquals("DK-2014122089123456", classe.findId(string.replace("$ID", "DK-2014122089123456")));
        assertEquals("DK-2014122089123456", classe.findId(string.replace("$ID", "DK-2014122089123456")));
        assertEquals("AA-2014122089123456", classe.findId(string.replace("$ID", "AA-2014122089123456")));
        assertEquals("FA-2014122089123456", classe.findId(string.replace("$ID", "FA-2014122089123456")));
        assertEquals("DK-2014122089123456", classe.findId(string.replace("$ID", "DK-2014122089123456")));
    }

    @Test
    public void testFailOnShortId() throws Exception
    {
        try {
            classe.findId(string.replace("$ID", "DK-123456789012345"));
            fail("invalid id");
        }
        catch (Exception e){
        }
    }

    @Test
    public void failOnLongId() throws Exception{
        try {
            classe.findId(string.replace("$ID", "DK-12345678901234567"));
            fail("invalid id");
        }
        catch (Exception e){

        }
    }

    @Test
    public void failOnNonvalidCountryCode() throws Exception{
        try {
            classe.findId(string.replace("$ID", "12-1234567890123456"));
            fail("invalid id");
        }
        catch (Exception e){

        }

    }

    @Test
    public void failOnShortCountryCode() throws Exception{
        try {
            classe.findId(string.replace("$ID", "A-12345678901234576"));
            fail("invalid id");
        }
        catch (Exception e){

        }
    }

    @Test
    public void failOnNonNumericIdSection() throws Exception{
        try {
            classe.findId(string.replace("$ID", "SK-1a34567890123456"));
            fail("invalid id");
        }
        catch (Exception e){

        }
    }

    @Test
    public void failOnInvalidIdStructure() throws Exception{
        try {
            classe.findId(string.replace("$ID", "AB01234567891234567890"));
            fail("invalid id");
        }
        catch (Exception e){

        }

    }

    @Test
    public void failOnInvalidMonthInDate(){
        try {
            classe.findId(string.replace("$ID", "AB-2014130189123456"));
            fail("invalid id");
        }
        catch (Exception e){

        }
    }

    @Test
    public void failOnInvalidDayInDate(){
        try {
            classe.findId(string.replace("$ID", "AB-2014124089123456"));
            fail("invalid id");
        }
        catch (Exception e){

        }
    }
}
