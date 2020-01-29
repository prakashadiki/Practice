package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelColor {

	
	public void setExcelCellColor() throws Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("./Practice.xlsx")));
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		if (row == null)
			row = sheet.createRow(2);
		Cell cell = row.getCell(2);
		if (cell == null)
			cell = row.createCell(2);
		CellStyle style = workbook.createCellStyle();
		String color = "green";
		if(color.equalsIgnoreCase("GREEN")) {
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		if(color.equalsIgnoreCase("RED")) {
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		cell.setCellStyle(style);
		FileOutputStream fos = new FileOutputStream(new File("./Practice.xlsx"));
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
	
	
	@Test
	public void setFontColor() throws Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("./Practice.xlsx")));
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(3);
		if (row == null)
			row = sheet.createRow(3);
		Cell cell = row.getCell(3);
		if (cell == null)
			cell = row.createCell(3);
		CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
        style.setFont(font);
		String data = "Ameex Tech";
		cell.setCellStyle(style);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(new File("./Practice.xlsx"));
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}
