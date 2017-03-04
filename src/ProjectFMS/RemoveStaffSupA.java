package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class RemoveStaffSupA extends JFrame {
    private String type,depa;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public RemoveStaffSupA() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDeleteStaff = new JLabel("Delete Staff / Supervisors");
        lblDeleteStaff.setBounds(150, 11, 150, 40);
        contentPane.add(lblDeleteStaff);

        JLabel lblStaffName = new JLabel("Staff / Supervisor Name:");
        lblStaffName.setBounds(43, 78, 119, 14);
        contentPane.add(lblStaffName);

        JLabel lblEnterReasonFor = new JLabel("Enter Reason for Deletion:");
        lblEnterReasonFor.setBounds(43, 124, 156, 14);
        contentPane.add(lblEnterReasonFor);

        JLabel labelErr = new JLabel("");
        labelErr.setBounds(116, 169, 248, 14);
        contentPane.add(labelErr);


        textField = new JTextField();
        textField.setBounds(234, 75, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(234, 121, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnDelete = new JButton("Delete!");
        btnDelete.setBounds(180, 201, 89, 23);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText()==""||textField.getText()=="")
                {
                    labelErr.setText("All fields are mandatory.");
                }
                else
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
                            if(split[0].equals(textField.getText()))
                            {
                                type=split[2];
                                depa=split[3];
                                updateUserPasswordFile(split[0]);		//Facade pattern
                                updateStaffSupFile(split[0]);
                                dispose();
                                //updateSupFile(split[0]);
                                break;
                            }
                        }

                    } catch (FileNotFoundException ee) {
                        // TODO Auto-generated catch block
                        ee.printStackTrace();
                    }
                }
            }

            private void updateStaffSupFile(String username) {
                // TODO Auto-generated method stub
                if (type.equals("Staff"))
                {
                    InputStream in;
                    try {
                        System.out.println("Writing user.password file");
                        in = new FileInputStream(depa+"Staff.csv");
                        StringBuilder sb=new StringBuilder();
                        Scanner sc=new Scanner(in);
                        while (sc.hasNextLine())
                        {
                            String x=sc.nextLine();
                            String split2[] = x.split(",");
                            if (split2[0].equals(username))
                                continue;
                            else
                                sb.append(x+"\n");
                            System.out.println(split2[0]+" "+username);
                        }
                        in.close();
                        FileWriter fileWriter1 = new FileWriter(depa+"Staff.csv",false);
                        fileWriter1.write(sb.toString());
                        fileWriter1.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                else if (type.equals("Supervisor"))
                {
                    InputStream in2;
                    try {
                        System.out.println("Writing supervisor file");
                        in2 = new FileInputStream("Supervisor.csv");
                        StringBuilder sb=new StringBuilder();
                        Scanner sc=new Scanner(in2);
                        int i=0;
                        while (sc.hasNextLine())
                        {
                            String x=sc.nextLine();
                            String split2[] = x.split(",");
                            if (split2[0].equals(username))
                                continue;
                            else
                                    sb.append(x+"\n");
                            System.out.println(split2[0]+" "+username);
                        }
                        in2.close();
                        FileWriter fileWriter3 = new FileWriter("Supervisor.csv",false);
                        fileWriter3.write(sb.toString());
                        fileWriter3.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

            private void updateUserPasswordFile(String username) {
                // TODO Auto-generated method stub
                InputStream in;
                try {
                    System.out.println("Writing user.password file...");
                    in = new FileInputStream("User_Password.txt");
                    StringBuilder sb=new StringBuilder();
                    Scanner sc=new Scanner(in);
                    int i=0;
                    while (sc.hasNextLine())
                    {
                        String x=sc.nextLine();
                        String split1[] = x.split(",");

                        if (split1[0].equals(username))
                            continue;
                        else
                            if(i==0){
                                sb.append(x);
                                i++;}
                            else
                                sb.append("\n"+x);
                            System.out.println(split1[0]+" "+username);

                    }
                    in.close();
                    FileWriter fileWriter1 = new FileWriter("User_Password.txt",false);
                    fileWriter1.write(sb.toString());
                    fileWriter1.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        contentPane.add(btnDelete);

    }
}
