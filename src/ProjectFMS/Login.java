package ProjectFMS;

		import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

	public class Login extends JFrame 
	{
	Staff staff_login;
	Supervisor supervisor_login;
	Admin admin_login;
	public static String user,depa;
	public String passw;
	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField pswd;
	
	public Login() 
	{
		this.setVisible(true);
	       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Serif", Font.PLAIN, 31));
		lblLogin.setBounds(658, 11, 137, 104);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(534, 145, 82, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(534, 213, 82, 23);
		contentPane.add(lblPassword);
		
		user_name = new JTextField();
		user_name.setBounds(709, 146, 86, 20);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		pswd = new JPasswordField();
		pswd.setBounds(709, 214, 86, 20);
		contentPane.add(pswd);
		pswd.setColumns(10);
		JLabel label = new JLabel("");
		label.setBounds(543, 322, 276, 28);
		contentPane.add(label);

		JButton Register = new JButton("Register");
		Register.setBounds(636,400, 89, 23);
		contentPane.add(Register);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationForm nF = new RegistrationForm();
				nF.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(636, 350, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome a;
				StaffHome s;
				SupervisorHome su;
				String type;
					if (user_name.getText().isEmpty())
						label.setText("Username not filled");
					else if(String.valueOf(pswd.getPassword()).isEmpty())
						label.setText("Password not filled");
					else
					{	
						try
						{
						label.setText("");
						user=user_name.getText();
						passw=String.valueOf(pswd.getPassword());
						InputStream in = new FileInputStream("User_Password.txt");
						Scanner sc=new Scanner(in);
						int flag=0;
							while(sc.hasNextLine()) 
							{
							String x = sc.nextLine();
							String split[] = x.split(",");
							if(split[0].equals(user));
							{	
								flag=1;
								if (split[1].equals(passw))
								{
									depa=split[3];
									type=split[2];
									if (type.equals("Admin"))
									{
									find_admin(user,depa);
									a = new AdminHome(user,depa,admin_login);
									a.setVisible(true);
									dispose();
									}
									else if (type.equals("Staff"))
									{
										find_staff(user, depa);
										s=new StaffHome(user,depa,staff_login);
										s.setVisible(true);
										dispose();
									}
									else if (type.equals("Supervisor"))
									{
										find_supervisor(user, depa);
										su=new SupervisorHome(user,depa,supervisor_login);
										su.setVisible(true);
										dispose();
									}
								}
								else
									label.setText("Incorrect Password");
							}
						if(flag==0)
							label.setText("No such user exits");	
						}
						}
						catch(Exception e1){}
					}
			}
		});
	}

	private void find_staff(String user, String depa) {
		try {
			InputStream in=new FileInputStream(depa+"Staff.csv");
			Scanner sc=new Scanner(in);
			sc.nextLine();
			while(sc.hasNextLine()) 
			{
			String x=sc.nextLine();
			String split[] = x.split(",");
			if(split[0].equals(user))
			{
				//	public Staff(String username, String ID, String department, String name, String DOB, String address, String status){
				staff_login=new Staff(split[0],split[2],depa,split[3],split[4],split[5],split[12]);
			}
			}
		}
			catch (FileNotFoundException e) {
		}
		
	}
	
	private void find_supervisor(String user, String depa) {
		try {
			InputStream in=new FileInputStream("Supervisor.csv");
			Scanner sc=new Scanner(in);
			sc.nextLine();
			while(sc.hasNextLine()) 
			{
			String x=sc.nextLine();
			String split[] = x.split(",");
			if(split[0].equals(user)&&split[4].equals(depa))
			{
				supervisor_login=new Supervisor(split[2],split[0],split[3],depa,split[5],split[6]);
			}
			}
		}
			catch (FileNotFoundException e) {
		}
		
	}
	

	private void find_admin(String user, String depa) {
		try {
			InputStream in=new FileInputStream("Admin.csv");
			Scanner sc=new Scanner(in);
			sc.nextLine();
			String x=sc.nextLine();
			String split[] = x.split(",");
			if(split[1].equals(user)&&split[4].equals(depa));
			admin_login=new Admin(split[0],split[1],split[2],split[3],depa,split[5]);
		}
			catch (FileNotFoundException e) {
		}
		
	}
	}