import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    //  file 01
    private BufferedReader openFile(String windowPrompt)
    {
        Scanner sc=new Scanner(System.in);
        BufferedReader oFile=null;

        while(oFile==null)
        {
            try {
                System.out.println(windowPrompt);
                String fileName=sc.nextLine();
                oFile=new BufferedReader(new java.io.FileReader(fileName));
            }
            catch(IOException ex) {
                System.out.println("Brain-dead Fool enter a File Name properly...!");
            }
        }
        return oFile;
    }

    //  Actual reading
    public void readFile() {
        BufferedReader rFile = openFile("please Enter File Name to Read it :  ");
        try {
            while (true) {
                String Line = rFile.readLine();
                if (Line == null) {
                    break;
                }
                System.out.println(Line);
            }
            rFile.close();
        }

        catch (IOException ex)
        {
        }
    }

    public static void main(String[] args) {
        FileReader fr=new FileReader();

        fr.readFile();
    }
}



