package ApachePOI;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;
public class ExcelnfoToDatabase {
public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		con=Helperclass.putConnection();
		Statement st=con.createStatement();
	//if we want to create a table
	//String posql="create table playground(equp_id numeric(10)primary key,type varchar2(20),color varchar2(10),install_date date)";
		//st.execute(posql);
	FileInputStream fis=new FileInputStream(".\\DataFolder\\playgroundfile (2).xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("sheet1");
	int rows=sheet.getLastRowNum();
	for(int r=1;r<=rows;r++) 
	{
		XSSFRow row=sheet.getRow(r);
		int equp_id =(int) row.getCell(0).getNumericCellValue();
	String type=row.getCell(1).getStringCellValue();
	String color=row.getCell(2).getStringCellValue();
	String location=row.getCell(3).getStringCellValue();//Date org.apache.poi.xssf.usermodel.XSSFCell.getDateCellValue()
	 LocalDateTime date=  row.getCell(4).getLocalDateTimeCellValue();
	String psql="insert into playground values('"+equp_id+"','"+type+"','"+color+"','"+location+"','"+date+"')";
	st.execute(psql);
		System.out.println("USERDATA INSERTED IN DATABASE SUCCESSFULLY......");
		System.out.println("-----------------------------------------------------------------------------------");
		Statement st1=con.createStatement();
		   ResultSet rs=st1.executeQuery("select*from playground");
		   while((rs.next())){System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDate(5));
		   }
		  }
	    }
     catch(IOException|SQLException e)
	{
		System.out.println(e);
	}
  }
}