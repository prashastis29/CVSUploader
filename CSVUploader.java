import java.io.*;
import java.util.*;
import java.sql.*;

public class CSVUploader {
	

	public List<List<String>> uploadCSVFile(String filePath) throws IOException, SQLException
		{
			int i;
			List<List<String>> csvdata= new ArrayList<List<String>>();
			String line=null;
			BufferedReader br=null;
			
			try{
			br=new BufferedReader(new FileReader(filePath));
			while((line=br.readLine())!=null)
			{
				String[] splittedData= line.split(",");
				List<String> data= new ArrayList<String>(splittedData.length);
				for(String d : splittedData)
				{
					data.add(d);
				}
				System.out.println(data);
				csvdata.add(data);
				
			}
		
	       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			PreparedStatement ps= con.prepareStatement("insert into demo values(?,?,?,?)");
			
			for(List<String> csv : csvdata)
	        {
	            if(!csv.isEmpty())
	            {
	                for(i=1; i <= csv.size(); i++)
	                {
	                  	ps.setString(i,csv.get(i-1));
	                }
					int status= ps.executeUpdate();
					if (status == 1)
						System.out.println("inserted successfully");
	                else
						System.out.println("insertion failed"); 
	            }
	            System.out.print("\n");
	        }
			con.close();
			}
			
			finally
			{
				if(br!=null)
					br.close();
			}
			return csvdata;
		
		}

}
		


