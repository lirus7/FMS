package ProjectFMS;

        import java.io.File;
import java.io.FileWriter;

public class Leave {
    String toWhom,fromWhom,reason,startdate,enddate,status;
    Leave(String toWhom, String fromWhom, String reason, String startdate,String enddate, String status)
    {
        this.setSender(fromWhom);
        this.setReceiver(toWhom);
        this.setReason(reason);
        this.setstartdate(startdate);
        this.setenddate(enddate);
        this.setStatus(status);
        File myFile = new File("leavefile.csv");
        try
        {
            FileWriter fileWriter = new FileWriter(myFile,true);
            StringBuilder string1=new StringBuilder();
            string1.append("\r\n"+toWhom+","+fromWhom+","+reason+","+startdate+","+enddate+","+status);
            fileWriter.write(string1.toString());
            System.out.println(string1);
            fileWriter.close();
        }
        catch(Exception e){}
    }
    String getStatus()
    {
        return status;
    }
    String getSender()
    {
        return fromWhom;
    }
    String getReceiver()
    {
        return toWhom;
    }
    String getReason()
    {
        return reason;
    }
    String getstartdate()
    {
        return startdate;
    }
    String getenddate()
    {
        return enddate;
    }
    void setStatus(String status2) {
        this.status=status2;
    }
    void setstartdate(String date) {
        this.startdate=date;
    }
    void setenddate(String date) {
        this.enddate=date;
    }
    void setReason(String reason2) {
        this.reason=reason2;
    }
    void setReceiver(String toWhom2) {
        this.toWhom=toWhom2;

    }
    void setSender(String s) {
        this.fromWhom=s;
    }
}
