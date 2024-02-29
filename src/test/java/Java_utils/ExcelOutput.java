package Java_utils;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOutput {

		public static void Excelutils(Map<String,String>Doctors_Details,List<String> surgeriesList) throws Exception {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\OutputExcel.xlsx");
	    XSSFWorkbook workbook= new XSSFWorkbook();
	    XSSFSheet sheet1 = workbook.createSheet("Doctor's Details");
		XSSFRow row1 = sheet1.createRow(0);
		row1.createCell(0).setCellValue("Doctor Name");
		row1.createCell(1).setCellValue("Doctor Description");
		Set<String> keys = Doctors_Details.keySet();
		int i =1;
		for(String s:keys)  {
			XSSFRow row = sheet1.createRow(i);
			row.createCell(0).setCellValue(s);
			row.createCell(1).setCellValue(Doctors_Details.get(s));
			i++;
		}
		
		XSSFRow row15=sheet1.createRow(15);
	    row15.createCell(0).setCellValue("Surgeries List");
	    for(int r=16;r<surgeriesList.size()+16;r++) {
	    	XSSFRow row16=sheet1.createRow(r);
	    	row16.createCell(1).setCellValue(surgeriesList.get(r-16));
	    }
		
		workbook.write(file);
	    workbook.close();
	    file.close();
	}
	    
//	    XSSFRow row=sheet.createRow(0);
//	    row.createCell(0).setCellValue("1. Doncot's Name");
//	    row.createCell(1).setCellValue(Doctor_Name1);
	    
//	    XSSFRow row2=sheet.createRow(1);
//	    row2.createCell(0).setCellValue("1. Doctor Qualifications1");
//	    row2.createCell(1).setCellValue(Doctor_Qualifications1);
//	    
//	    XSSFRow row3=sheet.createRow(3);
//	    row3.createCell(0).setCellValue("2. Doncot's Name");
//	    row3.createCell(1).setCellValue(Doctor_Name2);
//	    
//	    XSSFRow row4=sheet.createRow(4);
//	    row4.createCell(0).setCellValue("2. Doctor Qualifications");
//	    row4.createCell(1).setCellValue(Doctor_Qualifications2);
//	    
//	    XSSFRow row6=sheet.createRow(6);
//	    row6.createCell(0).setCellValue("3. Doncot's Name");
//	    row6.createCell(1).setCellValue(Doctor_Name3);
//	    
//	    XSSFRow row7=sheet.createRow(7);
//	    row7.createCell(0).setCellValue("3. Doctor Qualifications");
//	    row7.createCell(1).setCellValue(Doctor_Qualifications3);
//	    
//	    XSSFRow row9=sheet.createRow(9);
//	    row9.createCell(0).setCellValue("4. Doncot's Name");
//	    row9.createCell(1).setCellValue(Doctor_Name4);
//	    
//	    XSSFRow row10=sheet.createRow(10);
//	    row10.createCell(0).setCellValue("4. Doctor Qualifications");
//	    row10.createCell(1).setCellValue(Doctor_Qualifications4);
	    
//	    XSSFRow row12=sheet.createRow(12);
//	    row12.createCell(0).setCellValue("5. Doctor's Name");
//	    row12.createCell(1).setCellValue(Doctor_Name5);
//	    XSSFRow row13=sheet.createRow(13);
//	    row13.createCell(0).setCellValue("5. Doctor Qualifications");
//	    row13.createCell(1).setCellValue(Doctor_Qualifications5);
		
}



