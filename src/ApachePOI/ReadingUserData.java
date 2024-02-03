package ApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingUserData {
public static void main(String[] args) {try {
	
	String excelpath=".\\DataFiles\\playground_table.xlsx";
	FileInputStream input=new FileInputStream(excelpath);
	XSSFWorkbook workbook=new XSSFWorkbook(input);
	XSSFSheet sheet=workbook.getSheetAt(0);//xssfsheet sheet=workbook.getsheet(sheet1)
	/*//using for loop
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(1).getLastCellNum();
	for(int r=0;r<=rows;r++){
		XSSFRow row=sheet.getRow(r);
		for(int c=0;c<cols;c++){
		XSSFCell cell=row.getCell(c);
		switch(cell.getCellType()) {
		case STRING:System.out.print(cell.getStringCellValue());break;
		case NUMERIC:System.out.print(cell.());break;}
		System.out.print("|");}
		System.out.println();}}*/
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
	}catch(IOException e) {
		System.out.println(e);
		}      
 }
}