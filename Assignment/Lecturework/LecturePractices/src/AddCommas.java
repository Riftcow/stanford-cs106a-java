
import java.util.*;

public class AddCommas{

    public static void main(String Args[])
    {

        while (true) {

            System.out.println("Enter your Number : ");

            Scanner sc= new Scanner(System.in);
            String digits =sc.nextLine();

            if (digits.length() == 0)
            {
                break;
            }

            System.out.println(addCommasToNumericString(digits));
        }
    }

    private static String addCommasToNumericString(String digits) {
        String result="";
        int counter=0;
        for(int i=digits.length()-1;i>=0;i--)
        {
            result=digits.charAt(i)+result;
            counter++;

            if(counter % 3 == 0 && i!= 0)
            {
                result= "," + result;
            }
        }
        return result;
    }
}
