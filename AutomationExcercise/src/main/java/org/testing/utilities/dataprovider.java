package org.testing.utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	
	@DataProvider(name="testdata")
	public Object[][] data() throws EncryptedDocumentException, IOException{
		String path="../AutomationExcercise/src/test/resources/data.xlsx";
		List<Object[]> list=excelReader.excel(path);
		Object[][] ob=new Object[list.size()][1];
		for(int i=0;i<list.size();i++) {
			ob[i]=list.get(i);
			 System.out.println(Arrays.toString((Object[]) ob[i]));
		}
		return ob;
	}

}
