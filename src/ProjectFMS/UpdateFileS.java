package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateFileS {

    public UpdateFileS(String s,String option) {

        if(option.equals("No"))
        {
        InputStream in;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            in = new FileInputStream("taskfile.csv");
            StringBuilder sb = new StringBuilder();
            StringBuilder anne = new StringBuilder();
            Scanner sc = new Scanner(in);
            BufferedReader br1 = new BufferedReader(new FileReader("ongoingtask.csv"));
            while (sc.hasNextLine()) {
                String x = sc.nextLine();
                String split1[] = x.split(",");
                if(split1[1].equals(s) && br1.readLine()==null)
                    anne.append(split1[0]+","+split1[1]+","+split1[2]+","+split1[3]+","+split1[4]+","+split1[5]+","+df.format(dateobj).toString());
                else if(split1[1].equals(s))
                    anne.append("\r\n"+split1[0]+","+split1[1]+","+split1[2]+","+split1[3]+","+split1[4]+","+split1[5]+","+df.format(dateobj).toString());
                else
                    sb.append("\r\n"+x);
            }
            in.close();
            FileWriter fileWriter1 = new FileWriter("taskfile.csv", false);
            fileWriter1.write(sb.toString());
            fileWriter1.close();
            FileWriter fileWriter2 = new FileWriter("ongoingtask.csv", true);
            fileWriter2.write(anne.toString());
            fileWriter2.close();
            in.close();
        } catch (IOException ert) {
            // TODO Auto-generated catch block
            ert.printStackTrace();
        }
    }
    else if(option.equals("Yes"))
        {
            InputStream in;
            try {
                in = new FileInputStream("ongoingtask.csv");
                StringBuilder sb = new StringBuilder();
                Scanner sc = new Scanner(in);
                while (sc.hasNextLine()) {
                    String x = sc.nextLine();
                    String split1[] = x.split(",");
                    if (split1[1].equals(s))
                        continue;
                    else
                        sb.append(x + "\n");
                }
                in.close();
                FileWriter fileWriter1 = new FileWriter("ongoingtask.csv", false);
                fileWriter1.write(sb.toString());
                fileWriter1.close();
            } catch (IOException ert) {
                // TODO Auto-generated catch block
                ert.printStackTrace();
            }
        }
    }
}