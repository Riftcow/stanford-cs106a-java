import java.io.*;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.*;

public class FileWriter {

    private BufferedReader openFile()
    {
        Scanner sc =new Scanner(System.in);

        BufferedReader oFile=null;
        while(oFile==null)
        {
            try {
                System.out.println("Please Enter File name to Copy!");
                String fileName=sc.nextLine();
                oFile=new BufferedReader(new FileReader(fileName));
            }
            catch (IOException ex)
            {
                System.out.println("Atleast give the file name to COPY! you Dumb!..");
            }
        }

        return oFile;
    }


    //  actual copying a File...

    public void writeFile()
    {
        BufferedReader wFile= openFile();
        try {
            PrintWriter writeF=new PrintWriter(new java.io.FileWriter("Hello.txt"));
            while(true) {
                String Line = wFile.readLine();
                if(Line==null)
                {
                    break;
                }
                writeF.println(Line);

            }
            wFile.close();
            writeF.close();
        }catch (IOException ex)
        {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {

        FileWriter fw=new FileWriter();
        fw.writeFile();
    }
}
