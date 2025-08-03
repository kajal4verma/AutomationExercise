package org.testing.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logCapture {
 public static void logs(Class<?> cls,String level,String msg) {
      Logger log=LogManager.getLogger(cls);
//      System.out.println("loghss dummyyy");
      switch (level.toLowerCase()){
	case "info": {
		log.info(msg);
		break;
	}
	case "error": {
		log.error(msg);
		break;
	}
	
	}
 }
}
