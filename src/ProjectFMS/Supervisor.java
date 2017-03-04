package ProjectFMS;

		import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class Supervisor {
	private String ID,username,name,department,DOB,address;
	private List<Staff> staff_under_me;
	private int no_of_staff,no_of_tasks;
	
	
	public Supervisor(String ID, String username, String name, String department, String DOB, String address)
	{
		this.setID(ID);
		this.setUsername(username);
		this.setName(name);
		this.setDepartment(department);
		this.setDOB(DOB);
		this.setAddress(address);
	}
	private void setAddress(String address2) {
		this.address=address2;
	}
	
	private void setDOB(String dOB2) {
		this.DOB=dOB2;
	}
	
	void setID(String ID)
	{
		this.ID=ID;
	}
	void setName(String Name)
	{
		this.name=Name;
	}
	void setDepartment(String dep)
	{
		this.department=dep;
	}
	void setUsername(String Username)
	{
		this.username=Username;
	}
	String getID()
	{
		return this.ID;
	}
	String getUsername()
	{
		return this.username;
	}
	String getName()
	{
		return this.name;
	}
	String getDepartment()
	{
		return this.department;
	}
	String getDOB()
	{
		return this.DOB;
	}
	String getAddress()
	{
		return this.address;
	}
	int getStaffNumber()
	{
		return this.no_of_staff;
	}
	int getTaskNumber()
	{
		return this.no_of_tasks;
	}
	public List getStaff()
	{
		return this.staff_under_me;
	}
	
	void addStaff(Staff staff)
	{
		staff_under_me.add(staff);
	}
	void viewStaff()
	{
		System.out.println(staff_under_me);
	}
	void deleteStaff(Staff staff)
	{
		this.no_of_staff--;
		this.staff_under_me.remove(staff);
		//rewrite file
		File myFile = new File("Supervisor.csv");
		
		/*try
		{
			FileWriter fileWriter = new FileWriter(myFile,true);
            StringBuilder string1=new StringBuilder();
           // string1.append("\r\n"+text+","+selecteditem+","+staff.getID()+","+staff.getDepartment()+","+"Unapproved");
            fileWriter.write(string1.toString());
            System.out.println(string1);
            fileWriter.close();
		}
		catch(Exception e){}*/
	}
	void assignTask(Task task)	//pass parameter to assign to only 1, some or all
	{
		
	}
	void sendLogisticReq(String text, String selecteditem, Supervisor super1)	//send logistic requirement to supervisor
	{
		
		File myFile = new File("inventoryreq.csv");
		try
		{
			FileWriter fileWriter = new FileWriter(myFile,true);
            StringBuilder string1=new StringBuilder();
            string1.append("\r\n"+text+","+selecteditem+","+super1.getID()+","+super1.getDepartment()+","+"Unapproved");
            fileWriter.write(string1.toString());
            System.out.println(string1);
            fileWriter.close();
		}
		catch(Exception e){}
	}
	void sendLeave(Leave l)
	{
		
	}
	void handleLeave(Leave l)
	{
		
	}
}
