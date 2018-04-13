import java.io.IOException;
import java.sql.SQLException;

public class TestMain {

	public static void main(String args[])
{
	try{
	String filePath="demoCSVFile.csv";
	CSVUploader c= new CSVUploader();
	c.uploadCSVFile(filePath);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	catch(SQLException s)
	{
		s.printStackTrace();
	}
	
}
}
