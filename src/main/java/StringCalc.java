import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * Created by andreas on 1/22/14.
 */
public class StringCalc {

    public static int add(final String inputString) throws Exception{

        int sum = 0;
        String input=inputString;
        String delimiter = "[,\\n]";
        if (inputString.length() == 0) return 0;
        if (inputString.startsWith("//")) {
            input = inputString.substring(4);
            delimiter = inputString.charAt(2) + "";
        }

        String[] stringArray = input.split(delimiter);
        String errorMessage = "";
        for(String s : stringArray){
                int val = Integer.parseInt(s);
                if (val < 0){
                    errorMessage += " " + val;
                }
                else
                    sum += val;
        }
        if (errorMessage.length() > 0){
            throw new Exception("negatives not allowed"+errorMessage);
        }

        return sum;
    }
}
