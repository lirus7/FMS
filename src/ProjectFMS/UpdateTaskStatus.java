package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class UpdateTaskStatus extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public UpdateTaskStatus(String s) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUpdateTaskStatus = new JLabel("Update Task Status");
        lblUpdateTaskStatus.setBounds(165, 29, 102, 14);
        contentPane.add(lblUpdateTaskStatus);

        JLabel lblTaskId = new JLabel("Task ID:");
        lblTaskId.setBounds(59, 75, 46, 14);
        contentPane.add(lblTaskId);

        textField = new JTextField();
        textField.setBounds(256, 72, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblTaskStatus = new JLabel("Task Status:");
        lblTaskStatus.setBounds(59, 130, 86, 14);
        contentPane.add(lblTaskStatus);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("NOT STARTED");
        comboBox.addItem("ONGOING");
        comboBox.addItem("COMPLETE");
        //if complete is selcetd, dialogue box saying generate task report? popus up
        comboBox.setBounds(240, 127, 102, 20);
        contentPane.add(comboBox);
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(178, 195, 89, 23);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().toString().equals("COMPLETE"))
                {
                    GenerateTaskReport qwer=new GenerateTaskReport(textField.getText());
                    qwer.setVisible(true);
                    new UpdateFileS(textField.getText(),"Yes");
                }
                else if(s.equals("staff") && comboBox.getSelectedItem().toString().equals("ONGOING"))
                    new UpdateFile(textField.getText());
                else if(s.equals("supervisor") && comboBox.getSelectedItem().toString().equals("ONGOING"))
                    new UpdateFileS(textField.getText(),"No");
                //System.out.println(s+" 12, "+textField.getText()+" , " + comboBox.getSelectedItem().toString().equals("ONGOING"));
                dispose();
            }
        });
        contentPane.add(btnUpdate);

    }
}
