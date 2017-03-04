package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrationReqA extends JFrame {
    private Admin boss;
    private String type,depa;
    private JLabel labelErr;

    private JPanel contentPane;
    private JTextField textField;
    public RegistrationReqA(Admin boss) {
        this.boss=boss;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegistrationRequests = new JLabel("Registration Requests");
        lblRegistrationRequests.setBounds(154, 27, 200, 20);
        contentPane.add(lblRegistrationRequests);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(57, 81, 69, 14);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(249, 78, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        labelErr = new JLabel("");
        labelErr.setBounds(118, 136, 217, 14);
        contentPane.add(labelErr);

        JButton btnAccept = new JButton("Accept");
        btnAccept.setBounds(94, 189, 89, 23);
        btnAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals(""))
                    labelErr.setText("Please enter a username.");
                else
                {
                    boss.addUser(textField.getText());
                    dispose();
                }
            }
        });
        contentPane.add(btnAccept);

        JButton btnReject = new JButton("Reject");
        btnReject.setBounds(220, 189, 89, 23);
        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals(""))
                    labelErr.setText("Please enter a username.");
                else
                {

                    try
                    {
                        FileInputStream in = new FileInputStream("Registrations.csv");
                        Scanner sc=new Scanner(in);
                        String x = sc.nextLine();
                        int flag=0;
                        while(sc.hasNextLine())
                        {
                            x = sc.nextLine();
                            String split[] = x.split(",");
                            if(split[0].equals(textField.getText()))
                            {
                                flag=1;
                                type=split[6];
                                depa=split[5];
                                boss.deleteUserReq(split[0], depa, type);
                                dispose();
                                //updateSupFile(split[0]);
                                break;
                            }
                        }

                        if (flag==0)
                            labelErr.setText("Invalid Username");

                    } catch (Exception ep) {
                        // TODO Auto-generated catch block
                        ep.printStackTrace();
                    }
                }
            }
        });
        contentPane.add(btnReject);
    }

}
