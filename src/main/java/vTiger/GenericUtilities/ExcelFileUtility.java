package vTiger.GenericUtilities;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of Generic Methods related to Excel Sheet
 * @author Rishabh
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This Method will read data from Excel sheet and return value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcel(String sheet , int rowno , int cellno ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);//need apache poi for excel
		Workbook wb = WorkbookFactory.create(fis); //without apache poi ooxml create method won't be there
		String value = wb.getSheet(sheet).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	/**
	 * This method will provide total rowcount of specific excel sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getExcelRowCount(String sheet ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	/**
	 * This method will write data into excel sheet
	 * @param sheet
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet , int rowno , int cellno ,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rowno);
		Cell ce = rw.createCell(cellno);
		ce.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos); //wse to yha koi bhi object create nhi krna but for learning purpose this 
		wb.close();		//this will write and this will return void so can not create object
	}
	
	/**
	 * This method will read multiple data from excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();
		Object [][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data [i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				//1 row me data nhi h			
			}			
		}
		return data;
		
	}
	
	
}
