package ProjectFMS;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
public class DisplayLog extends JFrame {
    public String qwer;
    public DisplayLog() {
    }
    public void show(String id) {
        qwer=id;
        count();
        initialiseObject();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        //table.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(900,200);
        frame.setVisible(true);
    }
    private Object[][] data;
    public static int total=0;
    public void count()
    {

        int i=0;
        InputStream in;
        try {

            in = new FileInputStream("inventoryreq.csv");
            Scanner sc=new Scanner(in);
            String x = sc.nextLine();
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[3].equals(qwer))
                    i++;
                System.out.println(qwer+" wefdasvxc  "+split[3]);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in1;
        try {
            in1 = new FileInputStream("acceptedreq.csv");
            Scanner sc=new Scanner(in1);
            String x = sc.nextLine();
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[3].equals(qwer))
                    i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in2;
        try {
            in2 = new FileInputStream("rejectedreq.csv");
            Scanner sc=new Scanner(in2);
            String x = sc.nextLine();
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[3].equals(qwer))
                    i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        total=i;
        data=new Object[total][6];
    }
    public void initialiseObject() {
        InputStream in;
        int i=0;
        try {
            in = new FileInputStream("inventoryreq.csv");
            Scanner sc=new Scanner(in);
            String x = sc.nextLine();
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                data[i][0]=split[0];
                data[i][1]=split[1];
                data[i][2]=split[2];
                data[i][3]=split[3];
                data[i][4]=split[4];
                data[i][5]="Pending";
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in1;
        try {
            in1 = new FileInputStream("acceptedreq.csv");
            Scanner sc=new Scanner(in1);
            String x = sc.nextLine();
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                data[i][0]=split[0];
                data[i][1]=split[1];
                data[i][2]=split[2];
                data[i][3]=split[3];
                data[i][4]=split[4];
                data[i][5]="Approved";
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in2;
        try {
            in2 = new FileInputStream("rejectedreq.csv");
            Scanner sc=new Scanner(in2);
            String x = sc.nextLine();
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                data[i][0]=split[0];
                data[i][1]=split[1];
                data[i][2]=split[2];
                data[i][3]=split[3];
                data[i][4]=split[4];
                data[i][5]="Rejected";
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //    logID,requirement,quantity,userID,department,status
    String[] columnNames = {"logID", "Rqmnt","Quantity","UserID","Department","Status"};

}
