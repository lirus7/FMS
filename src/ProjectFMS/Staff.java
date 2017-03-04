package ProjectFMS;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Staff {
	public String ID, username,department,name,DOB,address,status;
	public Supervisor department_supervisor;
	public int no_of_tasks=0;
	public Task task[];

	
	public Staff(String username, String ID, String department, String name, String DOB, String address, String status){
		this.setID(ID);
		this.setUsername(username);
		this.setDepartment(department);
		this.setDOB(DOB);
		this.setAddress(address);
		this.setStatus(status);
		this.setname(name);
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getID()
	{
		return this.ID;
	}
	public String getDepartment()
	{
		return this.department;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDOB()
	{
		return this.DOB;
	}
	public String getAddress()
	{
		return this.address;
	}
	public String getStatus()
	{
		return this.status;
	}

	private void setname(String name)
	{
		this.name=name;
	}
	private void setStatus(String status2) {
		this.status=status2;	
	}	
	
	private void setAddress(String address2) {
		this.address=address2;
	}

	private void setDOB(String dOB2) {
		this.DOB=dOB2;
	}

	private void setDepartment(String department2) {
		this.department=department2;
	}

	private void setUsername(String username2) {
		this.username=username2;
	}

	private void setID(String iD2) {
		this.ID=iD2;
	}

	void sendLogisticReq(String text, String selecteditem, Staff staff)	//send logistic requirement to supervisor
	{
		
		File myFile = new File("inventoryreq.csv");
		try
		{
			FileWriter fileWriter = new FileWriter(myFile,true);
            StringBuilder string1=new StringBuilder();
            string1.append("\r\n"+text+","+selecteditem+","+staff.getID()+","+staff.getDepartment()+","+"Unapproved");
            fileWriter.write(string1.toString());
            System.out.println(string1);
            fileWriter.close();
		}
		catch(Exception e){}
	}
	void sendLeave(Leave l)
	{
		
	}
	void updateTaskStatus(Task task)
	{
		
	}
	void generateTaskReport(Task task)
	{
		if (task.status=="COMPLETE")
		{
			try {
				String filename=task.taskID+"Report.txt";
				File file = new File(filename);

				if (file.createNewFile()){
					System.out.println("File created!");

						PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
						writer.println("The first line");
						writer.println("The second line");
						writer.close();


				}else{
					System.out.println("File already exists.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void updateStatus(String status)
	{
		this.status=status;
	}
}
