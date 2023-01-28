package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//step1 load the file into file input stream  - java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		//step2 create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3 navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		//step4 navigate to required row
		Row rw = sh.getRow(1);
		//step5 navigate to required cell
		Cell ce = rw.getCell(1);
		//step6 capture the data present inside the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
	}

}
