package ProjectFMS;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class SupervisTableA extends JFrame {
    public SupervisTableA() {
    }

    public void show() {
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
        InputStream in;
        try {
            int i=0;
            in = new FileInputStream("User_Password.txt");
            Scanner sc=new Scanner(in);
            String x = sc.nextLine();
            while(sc.hasNextLine())
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[2].equals("Supervisor"))
                    i++;
            }
            total=i;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        data=new Object[total][4];
    }
    public void initialiseObject() {
        InputStream in;
        try {
            int i=0;
            in = new FileInputStream("User_Password.txt");
            Scanner sc=new Scanner(in);
            String x = sc.nextLine();
            while(sc.hasNextLine()&& i<total)
            {
                x = sc.nextLine();
                String split[] = x.split(",");
                if(split[2].equals("Supervisor"))
                {
                    data[i][0]=split[0];
                    data[i][1]="Available";
                    data[i][2]=split[3];
                    data[i][3]=split[2];
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    String[] columnNames = {"Username", "Status", "Department", "Type"};

}

