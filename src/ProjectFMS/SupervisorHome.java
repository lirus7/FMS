package  ProjectFMS;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
//import javafx.scene.control.DatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class SupervisorHome extends JFrame {
    public Supervisor superv;
    public String username;
    public  SupervisorHome(String user,String depa,Supervisor superv) {
        this.superv=superv;
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("<html><body><table width='160'><tr><td height='40'>Home</td></tr></table></body></html>", new Home());
        jtp.addTab("<html><body><table width='160'><tr><td height='40'>Staff</td></tr></table></body></html>", new Staff1());
        jtp.addTab("<html><body><table width='160'><tr><td height='40'>Logistics</td></tr></table></body></html>", new Logistics1());
        jtp.addTab("<html><body><table width='160'><tr><td height='40'>Reports</td></tr></table></body></html>", new Reports());
        jtp.addTab("<html><body><table width='160'><tr><td height='40'>Requests</td></tr></table></body></html>", new Requests(user,depa));
        ClockLabel clock = new ClockLabel();
        clock.setBounds(1050,0,200,50);
        JButton Logout=new JButton("LOGOUT");
        Logout.setBounds(900,0,100,50);
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                WelcomeScreen2 frame = new WelcomeScreen2();
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
            JLabel l2=new JLabel("Name: "+superv.getName());
            JLabel l3=new JLabel("Username: "+superv.getUsername());
            JLabel l4=new JLabel("DOB: "+superv.getDOB());
            JLabel l5=new JLabel("Department: "+superv.getDepartment());
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            JButton b3=new JButton("View Leave");
            b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    DisplayLeave a=new DisplayLeave();
                    a.show(superv.getUsername());
                    a.setVisible(true);
                }
            });
            add(b3);
        }
    }
    class Staff1 extends JPanel{
        public Staff1() {
            JButton st=new JButton("View Staff");
            add(st);
            st.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a)
                {
                    FrameDemo t=new FrameDemo(superv.getDepartment());
                    t.show();
                    t.setVisible(true);
                }
            });
        }
    }

    class Logistics1 extends JPanel {
        public Logistics1() {
            JLabel label=new JLabel("Send Logistics Requests to Admin");
            add(label);
            JLabel l1=new JLabel("Requirement:");
            add(l1);
            JTextField t1=new JTextField("");
            add(t1);
            JLabel l2=new JLabel("Quantity:");
            add(l2);
            JComboBox<Integer> jcb = new JComboBox<Integer>();
            jcb.addItem(1);
            jcb.addItem(2);
            jcb.addItem(3);
            jcb.addItem(4);
            jcb.addItem(5);
            jcb.addItem(6);
            add(jcb);
            JLabel error=new JLabel("");
            JButton sendreq=new JButton("Send");
            sendreq.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a)
                {
                    if (t1.getText()=="")
                        error.setText("Please enter the requirement.");
                    else
                    {
                        superv.sendLogisticReq(t1.getText(), jcb.getSelectedItem().toString(), superv);
                        //Write to file inventoryreq.csv
                        try {
                            FileWriter in = new FileWriter("inventoryreq.csv",true);
                            StringBuilder string1=new StringBuilder();
                            string1.append("\r\n"+t1.getText()+","+jcb.getSelectedItem().toString()+","+superv.getID()+","+superv.getDepartment()+","+"Unapproved");
                            in.write(string1.toString());
                            in.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                }
            });
            add(sendreq);
            JButton b6=new JButton("View Logistics");
            b6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    DisplayLog a=new DisplayLog();
                    a.show(superv.getID());
                    a.setVisible(true);
                }
            });
            add(b6);
        }
    }
    class Reports extends JPanel {
        public Reports() {
            JButton b1=new JButton("Assign Tasks");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e1) {
                    AssignTaskS t=new AssignTaskS(superv.getUsername());
                    t.setVisible(true);
                }
            });
            add(b1);
            JButton b2=new JButton("View Tasks");
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ViewTasks s=new ViewTasks();
                    s.show(superv.getUsername());
                    s.setVisible(true);
                }
            });
            add(b2);
            JButton b3=new JButton("Update Task Status");
            b3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a)
                {
                    UpdateTaskStatus s=new UpdateTaskStatus("supervisor");
                    s.setVisible(true);
                }
            });
            add(b3);
        }
    }
    class Requests extends JPanel {
        public Requests(String user,String depa) {
            JLabel label=new JLabel("Request for Leave");
            add(label);
            JLabel l1=new JLabel("Reason:");
            add(l1);
            JTextField t1=new JTextField("");
            add(t1);
            JLabel l2=new JLabel("Start Date :");
            add(l2);
            UtilDateModel model = new UtilDateModel();
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
            add(datePicker);
            JLabel l3=new JLabel("End Date :");
            add(l3);
            UtilDateModel model1 = new UtilDateModel();
            JDatePanelImpl datePanel1 = new JDatePanelImpl(model1,p);
            JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1,new DateLabelFormatter());
            add(datePicker1);
            JLabel error=new JLabel("");
            JButton sendreq=new JButton("Send");
            sendreq.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent a)
                {
                    if (t1.getText()=="")
                        error.setText("Please enter the Reason");
                    else
                    {
                        String startdate=datePicker.getJFormattedTextField().getText();
                        String enddate=datePicker1.getJFormattedTextField().getText();
                        Leave l=new Leave(depa,user,t1.getText(),startdate,enddate,"Unapproved");
                        JOptionPane.showMessageDialog(null, "Sent Request for Leave from "+startdate+" till "+enddate);
                        t1.setText("");
                        datePicker.getJFormattedTextField().setText("");
                        datePicker1.getJFormattedTextField().setText("");
                    }
                }
            });
            add(sendreq);
        }
    }
}