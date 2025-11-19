
import java.util.*;

public class DeleteChar {

    public String removeAllOccurance(String str,char ch)
    {
        String result="";
        for (int i=0;i<str.length();i++)
        {
            if(ch!=str.charAt(i) )
            {
                result=result+str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        DeleteChar d1=new DeleteChar();

        System.out.println(d1.removeAllOccurance("Hello World welcome to this wierd life where Environment is watter", 'w'));
    }
}
