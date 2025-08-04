package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class excelReader {
	public static List<Object[]> excel(String path) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(path);
	     Workbook wb=WorkbookFactory.create(fi);
	     Sheet sheet=wb.getSheetAt(0);
	     int r=sheet.getPhysicalNumberOfRows();
	     List<Object[]> list=new ArrayList<>();
	     for(int i=1;i<r;i++) {
	    	 Row row=sheet.getRow(i);
	    	 String status=getcellvalue(row.getCell(1));
	    	 if(!status.equalsIgnoreCase("y")) {
	    		 continue;
	    	 }
	    	
	    		 String product=getcellvalue(row.getCell(0));
	    		 Object[] ob=new Object[] {product};
	    		 list.add(ob);
	    	
	     }
	     wb.close();
	     return list;
	}
	private static String getcellvalue(Cell cell) {
		if(cell==null) {
			return "";
			
		}
		switch (cell.getCellType()) {
		
		case STRING: {
			return cell.getStringCellValue();
			
		}
		case NUMERIC:
		{
			return new DataFormatter().formatCellValue(cell);

		}
				default:
			throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
		}
	}

}
