package Libraries;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelfileUtility {
	/**
	 * this method only read xlfile and return the value to caller
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readdatafromexcelfile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream ff=new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb=WorkbookFactory.create(ff);
		Sheet s=wb.getSheet(sheetname);
		String value=s.getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
	}
	/**
	 * This methode is use for multiple adding companies
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException{
    FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
    Workbook wbb=WorkbookFactory.create(fis);
	Sheet sh=wbb.getSheet(sheetName);
	int lastRow =sh.getLastRowNum(); 
	int lastCell=sh.getRow(0).getLastCellNum();
	Object[][] data = new Object[lastRow] [lastCell];
	for(int i=0;i<lastRow;i++)
	{
       for (int j=0;j<lastCell;j++) 
       {
        data[i][j]= sh.getRow(i+1).getCell(1).getStringCellValue();
	   }
    }
	return data;
}
}