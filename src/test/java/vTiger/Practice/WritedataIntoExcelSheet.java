package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//step1 load file using file input stream - java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		
		//step2 create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3 get sheet 	
		Sheet sh = wb.getSheet("Organizations");
		//step4 choose row
		Row rw = sh.getRow(1);
		//step5 create cell
		Cell cell = rw.createCell(7);
		//step6 provide cell value
	    cell.setCellValue("abcd");
		//step7 send data using file output stream to the sheet
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Test Data.xlsx");
		//step8 write data into workbook
		wb.write(fos);
		System.out.println("data is added");
		
	}

}
