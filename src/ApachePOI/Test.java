package ApachePOI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filePath = ".\\DataFolder\\playground_table.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet1 = wb.getSheetAt(0);
        //update the 1st cell in 1st row  with a value.
        //updateCell( sheet1, 0, 0, 0, "modifedValue");
        //delete row 2;
        removeRow(sheet1, 3);
        System.out.println("DELETING DATA IS COMPLETED.......");
    }

	/*private static void updateCell(XSSFSheet sheet, int sheetNum, int rowNum, int cellNum, String value) {
		 XSSFRow row = sheet.getRow( rowNum );
         XSSFCell cell = row.getCell( cellNum);
         cell.setCellValue( value );}
*/
	 private static void removeRow(XSSFSheet sheet, int rowIndex) {
	    	
	    	int lastRowNum=sheet.getLastRowNum();
	        if(rowIndex>=0&&rowIndex<lastRowNum){
	            sheet.shiftRows(rowIndex+1,lastRowNum, -1);
	        }
	        if(rowIndex==lastRowNum){
	            XSSFRow removingRow=sheet.getRow(rowIndex);
	            if(removingRow!=null){
	                sheet.removeRow(removingRow);
	            }
	        }
	    }
	}

    