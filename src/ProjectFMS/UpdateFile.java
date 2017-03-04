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

public class UpdateFile {

    public UpdateFile(String s) {

        InputStream in;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            in = new FileInputStream("taskfilestaff.csv");
            StringBuilder sb = new StringBuilder();
            StringBuilder anne = new StringBuilder();
            Scanner sc = new Scanner(in);
            int i=0;
            BufferedReader br1 = new BufferedReader(new FileReader("ongoingtask.csv"));
            while (sc.hasNextLine()) {
                String x = sc.nextLine();
                String split1[] = x.split(",");
                if(split1[1].equals(s) && br1.readLine()==null)
                    anne.append(split1[0]+","+split1[1]+","+split1[2]+","+split1[3]+","+split1[4]+","+split1[5]+","+df.format(dateobj).toString());
                else if(split1[1].equals(s))
                     anne.append("\r\n"+split1[0]+","+split1[1]+","+split1[2]+","+split1[3]+","+split1[4]+","+split1[5]+","+df.format(dateobj).toString());
                else
                {
                    if(i==0)
                    {
                    sb.append(x);
                    i++;
                    }
                    else
                        sb.append("\r\n"+x);
                }
            }
            in.close();
            FileWriter fileWriter1 = new FileWriter("taskfilestaff.csv", false);
            fileWriter1.write(sb.toString());
            fileWriter1.close();
            FileWriter fileWriter2 = new FileWriter("ongoingtask.csv", true);
            fileWriter2.write(anne.toString());
            fileWriter2.close();
        } catch (IOException ert) {
            // TODO Auto-generated catch block
            ert.printStackTrace();
        }
    }
}


//                    anne.append(split1[0]+","+split1[1]+","+split1[2]+","+split1[3]+","+split1[4]+","+split1[5]+","+df.format(dateobj).toString());
//                    sb.append(x + "\n");
