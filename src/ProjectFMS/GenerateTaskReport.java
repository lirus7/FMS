package ProjectFMS;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenerateTaskReport extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private String TaskID;
    public GenerateTaskReport(String TaskID) {
        setVisible(true);
        setBounds(100, 100, 450, 300);
        this.TaskID=TaskID;
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblDoYouWant = new JLabel("Do you want to generate Task Report?");
            lblDoYouWant.setBounds(114, 92, 241, 14);
            contentPanel.add(lblDoYouWant);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
						/*File f = null;
					      boolean bool = false;
					      try{
					         f = new File(TaskID+"Report.txt");
					         bool = f.createNewFile();
					         System.out.println("File created: "+bool);
					      }catch(Exception ae){
					      }*/
                        try{
                            PrintWriter writer = new PrintWriter(TaskID+"Report.txt", "UTF-8");
                            writer.println("System Generated Task Report\n");
                            writer.println("Task ID: "+TaskID);
                            writer.println("System Generated Time Stamp:\n");
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date dateobj = new Date();
                            writer.println(df.format(dateobj));
                            Calendar calobj = Calendar.getInstance();
                            writer.println(df.format(calobj.getTime()));
                            writer.println("Status: COMPLETED");

                            writer.close();
                        } catch (IOException aae) {
                        }
                        dispose();
                    }
                });

                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
