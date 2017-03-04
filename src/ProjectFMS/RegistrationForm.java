package ProjectFMS;

		import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.util.*;
public class RegistrationForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JDatePickerImpl datePicker;
	private String department,type;
	private JLabel l2, l3, l4, l5,l6, l7, l8;
	private JTextField Name, Username, Address;
	private JButton Submit, Clear;
	private JPasswordField Password;
	private JLabel lblRegistration,lblNewLabel;
	private JComboBox jcb;
	public RegistrationForm() {
	this.setVisible(true);
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 l2 = new JLabel("Name:");
	        l3 = new JLabel("Username:");
	        l4 = new JLabel("Password:");
	        l5 = new JLabel("DOB:");
	        l6 = new JLabel("Address:");
	        l7 = new JLabel("Department:");
	        l8 = new JLabel("Type:");
		    jcb = new JComboBox();
	        Name = new JTextField();
	        Username = new JTextField();
	        Password = new JPasswordField();
	        Address = new JTextField();
	        Submit = new JButton("Submit");
			jcb.addItem("Electricity");
			jcb.addItem("HVAC");
			jcb.addItem("Audio/Video");
			jcb.addItem("HouseKeeping");
			jcb.addItem("Security");
	        Submit.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if (Name.getText().isEmpty()||Username.getText().isEmpty()||Address.getText().isEmpty())
						lblNewLabel.setText("All fields are required");
					else
						{
				        File myFile = new File("Registrations.csv");
				        try
				        {
				            FileWriter fileWriter = new FileWriter(myFile,true);
				            StringBuilder string1=new StringBuilder();
			                string1.append("\r\n"+Username.getText()+","+String.valueOf(Password.getPassword())+","+Name.getText()+","+datePicker.getJFormattedTextField().getText().toString()+","+Address.getText()+","+jcb.getSelectedItem()+","+type);
			                fileWriter.write(string1.toString());
				            System.out.println(string1);
				            fileWriter.close();
				            dispose();
				        }
				        catch(IOException ex){}
				    }
					
				}
				});
		   
	        Clear = new JButton("Clear");
	        Clear.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					RegistrationForm r=new RegistrationForm();
					dispose();
				}
				});
	        l2.setBounds(386, 70, 200, 30);
	        l3.setBounds(386, 111, 200, 30);
	        l4.setBounds(386, 152, 200, 30);
	        l5.setBounds(386, 193, 200, 30);
		    UtilDateModel model = new UtilDateModel();
		    Properties p = new Properties();
		    p.put("text.today", "Today");
		    p.put("text.month", "Month");
		    p.put("text.year", "Year");
		    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		    datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
	        l7.setBounds(386, 272, 200, 30);
			jcb.setBounds(618,272,200,30);
	        l8.setBounds(386, 313, 200, 30);
	        Name.setBounds(618, 70, 200, 30);
	        Username.setBounds(618, 111, 200, 30);
	        Password.setBounds(618, 152, 200, 30);
	        datePicker.setBounds(618, 193, 200, 30);
	        Address.setBounds(618, 234, 200, 30);
	        Submit.setBounds(568, 417, 100, 30);
	        Clear.setBounds(678, 417, 100, 30);
	        getContentPane().add(l2);
	        getContentPane().add(Name);
	        getContentPane().add(l3);
	        getContentPane().add(Username);
	        getContentPane().add(l4);
	        getContentPane().add(Password);
	        getContentPane().add(l5);
	        getContentPane().add(datePicker);
	        getContentPane().add(l6);
	        getContentPane().add(Address);
	        getContentPane().add(l7);
	        getContentPane().add(l8);
	        getContentPane().add(Submit);
	        getContentPane().add(Clear);
			getContentPane().add(jcb);
		    JButton btnStaff = new JButton("Staff");
	        JButton btnSupervisor = new JButton("Supervisor");
	        btnStaff.setBounds(618, 314, 89, 23);
	        btnStaff.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					type="Staff";
					btnStaff.setBackground(Color.CYAN);
					btnSupervisor.setEnabled(false);
				}
				});
	        contentPane.add(btnStaff);
	        
	        btnSupervisor.setBounds(729, 314, 89, 23);
	        btnSupervisor.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					type="Supervisor";
					btnSupervisor.setBackground(Color.CYAN);
					btnStaff.setEnabled(false);
				}
				});
	        contentPane.add(btnSupervisor);
			lblRegistration = new JLabel("Registration");
	        lblRegistration.setFont(new Font("Serif", Font.PLAIN, 38));
	        lblRegistration.setBounds(575, 11, 212, 48);
	        contentPane.add(lblRegistration);
			lblNewLabel = new JLabel("");
	        lblNewLabel.setBounds(661, 496, 46, 14);
	        contentPane.add(lblNewLabel);
	}
}