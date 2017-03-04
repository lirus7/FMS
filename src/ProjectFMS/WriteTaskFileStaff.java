package ProjectFMS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lirus on 29/11/16.
 */
public class WriteTaskFileStaff {
    public WriteTaskFileStaff(String s1,String s2,String s3,String s4,String s5)
    {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            int n=(int)(Math.random() * ((1000 - 100) + 1) + 100);
            String s=Integer.toString(n);
            s="T"+s;
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader("taskfilestaff.csv"));
            if (br.readLine() == null)
                sb.append(s1+","+s+","+s2 + ","+ s3 + "," + s4 +","+s5+","+df.format(dateobj).toString());
            else
                sb.append("\r\n"+s1+","+s+","+ s2 + "," + s3 + "," + s4 +","+s5+","+df.format(dateobj).toString());
            FileWriter fileWriter1 = new FileWriter("taskfilestaff.csv",true);
            fileWriter1.write(sb.toString());
            fileWriter1.close();
        }
        //  userID taskid taskname taskdescription equipent deadlinedate
        catch(Exception e)
        {e.printStackTrace();}
    }
}
