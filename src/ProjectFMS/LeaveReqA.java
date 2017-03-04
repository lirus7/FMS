package ProjectFMS;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
public class LeaveReqA extends JFrame {
    public LeaveReqA() {
    }
    public void show() {
        count();
        initialiseObject();
        JTable table = new JTable(data, columnNames);
        table.setSize(1200, 1200);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        //table.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(800,200);
        frame.setVisible(true);
    }
    private Object[][] data;
    public static int total=0;
    public void count()
    {
        InputStream in;
        try {
            int i=0;
            in = new FileInputStream("leavefile.csv");
            Scanner sc=new Scanner(in);
            String x = sc.nextLine();
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                i++;
            }
            total=i;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        data=new Object[total][7];
    }
    public void initialiseObject() {
        InputStream in;
        try {
            int i=0;
            in = new FileInputStream("leavefile.csv");
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
                data[i][5]=split[5];
                data[i][6]="Pending";
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //LeaveID	Department	Username	Reason	StartDate EndDate	Status
    String[] columnNames = {"LeaveID", "Department", "Username", "Reason","StartDate","EndDate","Status"};

}
