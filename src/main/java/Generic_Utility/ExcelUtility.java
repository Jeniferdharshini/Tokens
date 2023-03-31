package Generic_Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelData(String sheet, int rowno,int cellno) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/propertyFileActiveTime.txt");

		Workbook book = WorkbookFactory.create(fis);
			DataFormatter format= new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheet).getRow(rowno).getCell(cellno));
		return data;
		
}
	public String getExcelDataByFormatter(String sheet, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fie=new FileInputStream("./src/test/resources/Exceldata.xlsx");
	     Workbook book=WorkbookFactory.create(fie);
	     
	     DataFormatter format=new DataFormatter();
	     String data = format.formatCellValue(book.getSheet(sheet).getRow(rowNum).getCell(cellNum));
	     return data;
	}
	
		
}

