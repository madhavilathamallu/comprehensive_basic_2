package sdetAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndWriteData {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Read the data from Excel
		List<Course> courses = readDataFromExcel("D://Madhu-Learning//SeleniumFramework//IntroductionProject//excelFiles//data.xlsx");
		
		//Display the data in console
		for(Course course: courses) {
			System.out.println(course);
		}

	}

	private static List<Course> readDataFromExcel(String fileName) throws FileNotFoundException, IOException {
		List<Course> courses = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(new File(fileName));
				Workbook workbook = WorkbookFactory.create(fis)){
			Sheet sheet = workbook.getSheetAt(0);
			for(Row row: sheet) {
				String name = getValueFromCell(row.getCell(0));
				String course = getValueFromCell(row.getCell(1));
				String fee = getValueFromCell(row.getCell(2));
				
				courses.add(new Course(name,course,fee));
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return courses;
	}

	private static String getValueFromCell(Cell cell) {
		if(cell!=null) {
			CellType cellType = cell.getCellType();
			if(cellType == CellType.STRING) {
				return cell.getStringCellValue();
			}else if(cellType == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}else if(cellType == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cellType == CellType.BLANK) {
			return "";
		}else {
			return cell.toString();
		}
		
	}
		return "";
}
}
