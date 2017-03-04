package ProjectFMS;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePanelImpl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

public class AssignTaskA extends JFrame {
	private JPanel contentPane;
	public JDatePickerImpl datePicker;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public AssignTaskA() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignTaskTo = new JLabel("Assign Task to Supervisor");
		lblAssignTaskTo.setBounds(146, 22, 176, 14);
		contentPane.add(lblAssignTaskTo);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(45, 61, 81, 14);
		contentPane.add(lblUsername);
		
		JLabel lblTaskName = new JLabel("Task Name:");
		lblTaskName.setBounds(45, 88, 65, 14);
		contentPane.add(lblTaskName);
		
		JLabel lblNewLabel = new JLabel("Task Description:");
		lblNewLabel.setBounds(45, 113, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEquipment = new JLabel("Equipment:");
		lblEquipment.setBounds(45, 138, 65, 14);
		contentPane.add(lblEquipment);
		
		JLabel lblTaskDeadline = new JLabel("Task Deadline:");
		lblTaskDeadline.setBounds(45, 163, 81, 14);
		contentPane.add(lblTaskDeadline);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(128, 202, 222, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setBounds(173, 250, 89, 23);
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals(""))
					lblNewLabel_1.setText("All fields are mandatory.");
				else
					new WriteTaskFile(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),datePicker.getJFormattedTextField().getText().toString());
				dispose();
			}
		});
		contentPane.add(btnAssign);
		
		
		textField = new JTextField();
		textField.setBounds(200, 58, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 85, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 110, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 135, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePicker.setBounds(200, 160, 86, 20);
		contentPane.add(datePicker);
	}
}