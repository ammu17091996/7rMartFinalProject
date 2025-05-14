package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public static XSSFWorkbook w;

	public static XSSFSheet s;

	public static FileInputStream f;

	public static String readStringData(int i, int j,String sheet) throws IOException
	{

		f = new FileInputStream("C:\\Users\\NITHYA R NAIR\\eclipse-workspace\\7rmartFinalProject\\src\\test\\resources\\TestingData.xlsx");
		w = new XSSFWorkbook(f);

		s = w.getSheet(sheet);

		Row r = s.getRow(i);

		Cell c = r.getCell(j);

		return c.getStringCellValue();
	}

	public static String readIntegerData(int i, int j,String sheet) throws IOException {

		f = new FileInputStream("C:\\Users\\NITHYA R NAIR\\eclipse-workspace\\7rmartFinalProject\\src\\test\\resources\\TestingData.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}
}





