package utility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook workbook;
	private static Sheet sheet;

	public static void localExcel(String filePath, String sheetName)
	{
		try 
		{
			FileInputStream file = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getCellData(int rowNum, int colNum) 
	{
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        if (cell == null) 
        {
            return ""; 
        }

        if (cell.getCellType() == CellType.STRING) 
        {
            return cell.getStringCellValue();
        }
        else if (cell.getCellType() == CellType.NUMERIC) 
        {
            return String.valueOf((long) cell.getNumericCellValue()); 
        } 
        else if (cell.getCellType() == CellType.BOOLEAN)
        {
            return String.valueOf(cell.getBooleanCellValue());
        } 
        else 
        {
            return ""; 
        }
    }


}
