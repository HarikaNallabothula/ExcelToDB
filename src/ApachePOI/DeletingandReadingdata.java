package ApachePOI;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DeletingandReadingdata {
	public static void main(String[] args) {try {
		Connection con=null;
		con=Helperclass.putConnection();
	String excelpath=".\\DataFiles\\playground_table.xlsx";
		FileInputStream input=new FileInputStream(excelpath);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheetAt(0);//xssfsheet sheet=workbook.getsheet(sheet1)
		Iterator iterator=sheet.iterator();
		while(iterator.hasNext()){
			XSSFRow row=(XSSFRow) iterator.next();
			Iterator cellIterator=row.cellIterator();
			while(cellIterator.hasNext()){ 
				XSSFCell cell=(XSSFCell) cellIterator.next();
				switch(cell.getCellType()) {
				case STRING:System.out.print(cell.getStringCellValue());break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;}
				System.out.print("|  ");}
			System.out.println();} 
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs1=st.executeQuery("select equip_id,type,color,location,install_date from playground");
		while(rs1.next()){
		int equip_id=rs1.getInt(1);
		if(equip_id==31) 
			rs1.deleteRow();}
		System.out.println("DATA IS SUCCESSFULLY DELETED.....");
		
		
		/*
		 * Statement st=con.createStatement(); int
		 * cst=st.executeUpdate("Delete from playground where equip_id="); if(cst==1) {
		 * System.out.println("DATA DELETED SUCCESSFULLY............");} else {
		 * System .out.println("SOME TECHNICAL ISSUE");}
		 */
		Statement st1=con.createStatement();
		   ResultSet rs=st1.executeQuery("select*from playground");
		   while(rs.next()) {System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDate(5));
		   }
	}catch(SQLException | IOException e) {
		System.out.println(e);}}}