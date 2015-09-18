import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFSheet ExcelWSheet;
	 
    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;
	
  public static void setexcelfile(String Path) throws IOException {
        
     // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
  }
  
  public static XSSFSheet setexcelsheet(String sheetname) throws IOException {
      
	     // Set the Excel sheet
	  ExcelWSheet = ExcelWBook.getSheet(sheetname);
	  return ExcelWSheet;
	  }
  
  public static String getexcelcelldata(XSSFSheet Excelsheet,Integer Rownum, Integer Colnum) throws IOException {
	  Cell = Excelsheet.getRow(Rownum).getCell(Colnum);
      String Celldata = Cell.getStringCellValue();
      return Celldata;
  }
  
  public static void SetdataInExcel(XSSFSheet Excelsheet,Integer Rownum, Integer Colnum, String CapturedData) throws IOException {
	  Cell = Excelsheet.getRow(Rownum).getCell(Colnum);
	  Cell.setCellValue(CapturedData);
  }
  
  public static Integer getexcelrowcount(XSSFSheet Excelsheet) throws IOException {
	  Integer rowcount = Excelsheet.getLastRowNum();
      return rowcount;
  }
}
