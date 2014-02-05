import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by andreas on 2/5/14.
 */
public class Parser {

    private boolean failed = false;


    public String findId(String string) throws Exception {
        String bulk = "bulk id=\"";
        String dato="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date;

        int indexStart = string.indexOf(bulk);
        String str = string.substring(indexStart);
        int indexEnd = str.indexOf("\"/");

        str = str.substring(bulk.length(), indexEnd);


        if (str.matches("[A-Z]{2}-\\d{16}")) {
            dato = str.substring(3,11);
            if (sdf.parse(dato) == null) throw new Exception();
            return str;
        }
        else throw new Exception();
    }

}
