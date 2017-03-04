package ProjectFMS;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
public class AdminHome extends JFrame {
	public Admin boss;
	public  AdminHome(String user,String depa,Admin adm) {
		this.boss=adm;
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("<html><body><table width='160'><tr><td height='40'>Home</td></tr></table></body></html>", new Home());
		jtp.addTab("<html><body><table width='160'><tr><td height='40'>Staff</td></tr></table></body></html>", new Staff1());
		jtp.addTab("<html><body><table width='160'><tr><td height='40'>Logistics</td></tr></table></body></html>", new Logistics1());
		jtp.addTab("<html><body><table width='160'><tr><td height='40'>Reports</td></tr></table></body></html>", new Reports());
		jtp.addTab("<html><body><table width='160'><tr><td height='40'>Requests</td></tr></table></body></html>", new Requests());
		ClockLabel clock = new ClockLabel();
		clock.setBounds(1050,0,200,50);
		JButton Logout=new JButton("LOGOUT");
		Logout.setBounds(900,0,100,50);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); WelcomeScreen2 frame = new WelcomeScreen2();
				frame.setVisible(true);
				frame.start();
			}
		});
		add(Logout);
		add(clock);
		add(jtp);
	}
	class ClockLabel extends JLabel implements ActionListener {

		public ClockLabel() {
			super("" + new Date());
			Timer t = new Timer(1000, this);
			t.start();
		}

		public void actionPerformed(ActionEvent ae) {
			setText((new Date()).toString());
		}
	}

	class Home extends JPanel {
		public Home() {
			JLabel l1=new JLabel("Details: ");
			JLabel l2=new JLabel("Name: "+boss.getName());
			JLabel l3=new JLabel("Username: "+boss.getUsername());
			JLabel l4=new JLabel("DOB: "+boss.getDOB());
			JLabel l5=new JLabel("Department: "+boss.getDepartment());
			JLabel l6=new JLabel("Department: "+boss.getID());
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			add(l6);

		}
	}

	class Staff1 extends JPanel {

		public Staff1() {
			JButton b1=new JButton("View Staff");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StaffTableA t=new StaffTableA();
					t.show();
					t.setVisible(true);
				}
			});
			add(b1);
			JButton b2=new JButton("Delete User");
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RemoveStaffSupA t=new RemoveStaffSupA();
					t.setVisible(true);
				}
			});
			add(b2);

			JButton b3=new JButton("View Supervisors");
			add(b3);
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SupervisTableA t=new SupervisTableA();
					t.show();
					t.setVisible(true);
				}
			});
		}

	}

	class Logistics1 extends JPanel {
		public Logistics1() {
			JButton log=new JButton("View Logistics Requests");
			log.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InventA t=new InventA();
					t.show();
					t.setVisible(true);
				}
			});
			add(log);

			JButton man=new JButton("Manage Logistics Requests");
			man.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManageLogReqA am=new ManageLogReqA();
					am.setVisible(true);
				}
			});
			add(man);
		}
	}


	class Reports extends JPanel {
		public Reports() {
			JButton b1=new JButton("Assign Tasks");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AssignTaskA t=new AssignTaskA();
					t.setVisible(true);
				}
			});
			add(b1);
		}
	}
	class Requests extends JPanel {
		public Requests() {
			JButton b1=new JButton("View Registration Requests");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegReqA t=new RegReqA();
					t.show();
					t.setVisible(true);
				}
			});
			add(b1);
			JButton b2=new JButton("View Leave Requests");
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LeaveReqA t=new LeaveReqA();
					t.show();
					t.setVisible(true);
				}
			});
			add(b2);

			JButton b3=new JButton("Manage Registration Requests");
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrationReqA a=new RegistrationReqA(boss);
					//a.setAlwaysOnTop(true);
					a.setVisible(true);
				}
			});
			add(b3);
			JButton b4=new JButton("Manage Leave Requests");
			b4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManageLeaveA a=new ManageLeaveA();
					a.setVisible(true);
				}
			});
			add(b4);
		}
	}
}