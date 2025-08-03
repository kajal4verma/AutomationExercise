package org.testing.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesHandle {
	public static Properties loadProperties(String path) throws IOException {
		File f=new File(path);
		FileReader fr=new FileReader(f);
		Properties p=new Properties();
		p.load(fr);
		return p;
	}

}
