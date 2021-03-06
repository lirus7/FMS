package ProjectFMS;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
public class ViewTaskstaff extends JFrame {
    public String an1;
    public ViewTaskstaff() {
    }
    public void show(String ann) {
        an1=ann;
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
            in = new FileInputStream("taskfilestaff.csv");
            Scanner sc=new Scanner(in);
            String x;
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[0].equals(an1))
                    i++;
                System.out.println(split[0]+" , "+an1);
            }
            in.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in1;
        try {
            in1 = new FileInputStream("ongoingtask.csv");
            Scanner sc=new Scanner(in1);
            String x;
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[0].equals(an1))
                    i++;
                System.out.println(split[0]+" , "+an1);
            }
            in1.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        total=i;
        data=new Object[total][7];
    }
    public void initialiseObject() {
        int i=0;
        InputStream in;
        try {
            in = new FileInputStream("taskfilestaff.csv");
            Scanner sc=new Scanner(in);
            String x;
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[0].equals(an1)) {
                    data[i][0] = split[0];
                    data[i][1] = split[1];
                    data[i][2] = split[2];
                    data[i][3] = split[4];
                    data[i][4] = split[5];
                    data[i][5] = "Not Started";
                    data[i][6] = split[6];
                    i++;
                }
            }
            in.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStream in1;
        try {
            in1 = new FileInputStream("ongoingtask.csv");
            Scanner sc=new Scanner(in1);
            String x;
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[0].equals(an1)) {
                    data[i][0] = split[0];
                    data[i][1] = split[1];
                    data[i][2] = split[2];
                    data[i][3] = split[4];
                    data[i][4] = split[5];
                    data[i][5] = "ongoing";
                    data[i][6] = split[6];
                    i++;
                }
            }
            in1.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //  username taskid taskname taskdescription equipent deadlinedate
    //username taskid taskname equipent deadlinedate status
    String[] columnNames = {"Username", "TaskID", "Task", "Equipment","Deadline","Status","Time"};
}

