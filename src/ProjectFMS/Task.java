package ProjectFMS;

		import java.util.*;

public class Task {
	public int taskID;
	public Date deadline;
	public String status="NOT STARTED";	// NOT STARTED(default),ONGOING,COMPLETE	
	void setStatus(String s)
	{
		this.status=s;
	}
	String getStatus()
	{
		return this.status;
	}
	void setDeadline(Date s)
	{
		this.deadline=s;
	}
	Date getDeadline()
	{
		return this.deadline;
	}
	void generateCompletionReport()
	{
		if (status=="COMPLETE")
		{
			
			//generate report with system generated timestamps
			
		}
	}
	
	
}
