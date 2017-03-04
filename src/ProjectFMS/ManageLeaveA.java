package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ManageLeaveA extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    public ManageLeaveA() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblHandleLeaveRequests = new JLabel("Handle Leave Requests");
        lblHandleLeaveRequests.setBounds(151, 29, 124, 14);
        contentPane.add(lblHandleLeaveRequests);

        JLabel lblLeaveId = new JLabel("Leave ID:");
        lblLeaveId.setBounds(55, 84, 64, 14);
        contentPane.add(lblLeaveId);

        JLabel lblReasonComments = new JLabel("Reason / Comments:");
        lblReasonComments.setBounds(55, 132, 143, 14);
        contentPane.add(lblReasonComments);

        textField = new JTextField();
        textField.setBounds(265, 81, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(265, 129, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel label = new JLabel("");
        label.setBounds(109, 170, 203, 14);
        contentPane.add(label);

        JButton btnApprove = new JButton("Approve");
        btnApprove.setBounds(109, 204, 89, 23);
        btnApprove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals(""))
                    label.setText("Please enter a leave ID.");
                else
                {
                    InputStream in;
                    try {
                        in = new FileInputStream("leavefile.csv");
                        StringBuilder sb=new StringBuilder();
                        StringBuilder anne=new StringBuilder();
                        Scanner sc=new Scanner(in);
                        while (sc.hasNextLine())
                        {
                            String x=sc.nextLine();
                            String split1[] = x.split(",");
                            if (split1[0].equals(textField.getText()))
                                anne.append("\r\n"+x);
                            else
                                sb.append(x+"\n");
                        }
                        in.close();
                        FileWriter fileWriter1 = new FileWriter("leavefile.csv",false);
                        fileWriter1.write(sb.toString());
                        fileWriter1.close();
                        FileWriter fileWriter2 = new FileWriter("acceptedleave.csv",true);
                        fileWriter2.write(anne.toString());
                        fileWriter2.close();
                    } catch (IOException ert) {
                        // TODO Auto-generated catch block
                        ert.printStackTrace();
                    }
                    dispose();
                }

            }
        });
        contentPane.add(btnApprove);
        JButton btnReject = new JButton("Reject");
        btnReject.setBounds(223, 204, 89, 23);
        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals(""))
                    label.setText("Please enter a leave ID.");
                else
                {
                    InputStream in1;
                    try {
                        in1 = new FileInputStream("leavefile.csv");
                        StringBuilder sb=new StringBuilder();
                        StringBuilder sn=new StringBuilder();
                        Scanner sc=new Scanner(in1);
                        while (sc.hasNextLine())
                        {
                            String x=sc.nextLine();
                            String split1[] = x.split(",");
                            if (split1[0].equals(textField.getText()))
                                sn.append("\r\n"+x);
                            else
                                sb.append(x+"\n");
                        }
                        in1.close();
                        FileWriter fileWriter3 = new FileWriter("leavefile.csv",false);
                        fileWriter3.write(sb.toString());
                        fileWriter3.close();
                        FileWriter fileWriter4 = new FileWriter("rejectedleave.csv",true);
                        fileWriter4.write(sn.toString());
                        fileWriter4.close();
                    } catch (IOException ert) {
                        // TODO Auto-generated catch block
                        ert.printStackTrace();
                    }
                    dispose();
                }

            }
        });
        contentPane.add(btnReject);
    }
}
