package ProjectFMS;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Admin {
	private String ID, username,DOB,department,address,name;
	private List<Staff> complete_staff_list;
	private List<Supervisor> supevisors_under_me;
	private List<Task> complete_task_list;
	private List<String> logistics_list;
	String y;
	public Admin(String ID, String username, String name, String DOB, String department, String address)
	{
		this.setID(ID);
		this.setUsername(username);
		this.setName(name);
		this.setDOB(DOB);
		this.setDepartment(department);
		this.setAddress(address);
	}

	private void setName(String name2) {
		this.name=name2;
	}

	private void setAddress(String address2) {
		this.address=address2;
	}

	private void setDepartment(String dOB2) {
		this.department=dOB2;
	}

	private void setDOB(String dOB2) {
		this.DOB=dOB2;
	}

	private void setUsername(String username2) {
		this.username=username2;
	}

	private void setID(String iD2) {
		this.ID=iD2;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getDOB() {
		return this.DOB;
	}

	public String getUsername() {
		return this.username;
	}

	public String getID() {
		return this.ID;
	}

	void addUser(String username)
	{
		System.out.println();
		try {
			InputStream in=new FileInputStream("Registrations.csv");
			Scanner sc=new Scanner(in);
			sc.nextLine();
			String x="";
			while (sc.hasNextLine())
			{
				x=sc.nextLine();
				String split[] = x.split(",");
				if(split[0].equals(username))
				{
					if (split[6].equals("Staff"))
					{
						try
						{
							System.out.println("Writing department file");
							//InputStream depfile=new FileInputStream(department+"staff.csv");
							FileWriter fileWriter = new FileWriter(split[5]+"Staff.csv",true);
							StringBuilder string1=new StringBuilder();
							int n=(int)(Math.random() * ((1000 - 100) + 1) + 100);
							String s=Integer.toString(n);
							y=generateID(split[5])+s;
							string1.append("\r\n"+split[0]+","+split[1]+","+y+","+split[2]+","+split[3]+","+split[4]+","+split[5]+","+"0,[],0,0,0,available");
							fileWriter.write(string1.toString());
							System.out.println(string1.toString());
							fileWriter.close();
							System.out.println("Writing up file");

							FileWriter fileWriter2 = new FileWriter("User_Password.txt",true);
							StringBuilder string2=new StringBuilder();
							string2.append("\r\n"+username+","+split[1]+","+split[6]+","+split[5]);
							fileWriter2.write(string2.toString());
							updateRegistrationFile(username, split[5], split[6]);
							fileWriter2.close();
						}
						catch(IOException e)
						{}
					}
					else
					{
						try
						{
							System.out.println("Writing supervisor file");
							//InputStream depfile=new FileInputStream(department+"staff.csv");
							FileWriter fileWriter = new FileWriter("Supervisor.csv",true);
							StringBuilder string1=new StringBuilder();
							int n=(int)(Math.random() * ((1000 - 100) + 1) + 100);
							String s=Integer.toString(n);
							y=generateID(split[5])+s;
							string1.append("\r\n"+split[0]+","+split[1]+","+y+","+split[2]+","+split[3]+","+split[4]+","+split[5]+","+"0,[],0,0,0,available");
							fileWriter.write(string1.toString());
							System.out.println(string1.toString());
							fileWriter.close();
							System.out.println("Writing up file");
							FileWriter fileWriter2 = new FileWriter("User_Password.txt",true);
							StringBuilder string2=new StringBuilder();
							string2.append("\r\n"+username+","+split[1]+","+split[6]+","+split[5]);
							fileWriter2.write(string2.toString());
							updateRegistrationFile(username, split[5], split[6]);
							fileWriter2.close();
						}
						catch(IOException e)
						{}
					}
					break;
				}
				//x=sc.nextLine();
			}
		}
		catch (FileNotFoundException e) {}
	}
	void deleteUserReq(String username, String department, String type)
	{
		try {
			InputStream in=new FileInputStream("Registrations.csv");
			Scanner sc=new Scanner(in);
			sc.nextLine();
			String x;
			while (sc.hasNextLine())
			{
				x=sc.nextLine();
				String split[] = x.split(",");
				if(split[0].equals(username));
				{
					updateRegistrationFile(username, department, type);
				}
			}
		}
		catch(Exception e){}
	}

	private void updateRegistrationFile(String username, String department, String type) {
		// TODO Auto-generated method stub
		InputStream in;
		try {
			System.out.println("Writing reg file");
			in = new FileInputStream("Registrations.csv");
			StringBuilder sb=new StringBuilder();
			Scanner sc=new Scanner(in);
			int i=0;
			while (sc.hasNextLine())
			{
				String x=sc.nextLine();
				String split[] = x.split(",");
				if (split[0].equals(username))
				{
					System.out.println(split);
					continue;
				}
				else
					if(i==0)
					{sb.append(x);i++;}
					else
						sb.append("\r\n"+x);
			}
			System.out.println(sb.toString());
			in.close();
			FileWriter fileWriter1 = new FileWriter("Registrations.csv",false);
			fileWriter1.write(sb.toString());
			fileWriter1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String generateID(String department)
	{
		if (department.equals("AudioVideo"))
			y="AV";
		else if (department.equals("Electricity"))
			y="EL";
		else if (department.equals("Housekeeping"))
			y="HK";
		else if (department.equals("HVAC"))
			y="HV";
		else if (department.equals("Security"))
			y="SS";
		System.out.println(y);

		return(y);
	}

	void deleteUser()
	{

	}
	void addSupervisor(Supervisor sup)
	{

	}
	void viewStaff()
	{

	}
	void viewSupervisor(Supervisor sup)
	{

	}
	void deleteStaff(Staff staff)
	{

	}
	void deleteSupervisor(Supervisor sup)
	{

	}
	void assignTasks(Task t)	//Assign task to supervisor
	{

	}
	void handleSupervisorRequest()		//Accept or reject
	{

	}
	//Supervisors can send logistics approval requests for inventory to GM.

	void handleLeave(Leave l)		//Send leave to GM
	{

	}
	void viewTaskReports()
	{
		System.out.println(complete_task_list);
	}
}