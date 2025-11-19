
import java.util.*;

public class Palindrome {



    public boolean isPalindrome(String str)
    {
        for(int i=0;i< str.length()/2;i++)
        {
            if(str.charAt(i)!= str.charAt(str.length()-(i+1)) )
            {
                return false;
            }
        }
        return true;
    }

    public String reverseString(String str)
    {
        String result="";
        for(int i=0;i<str.length();i++)
        {
            result= str.charAt(i)+result;
        }
        return result;
    }

        //  simpoler version of palindrome checking...
    public boolean checkForPalindrome(String str)
    {
        if(str.equals(reverseString(str)))
        {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {

            Palindrome p1=new Palindrome();
            System.out.println(p1.isPalindrome("noon"));

        System.out.println(p1.reverseString("Hello"));

        //simpler verion test
        System.out.println(p1.checkForPalindrome("racecar"));
    }
}
