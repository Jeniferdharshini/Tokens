package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_Utility {
	private static final String Key = null;

	public String getKeyValue(String Key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/propertyFileActiveTime.txt");
		Properties pro =new Properties();
		pro.load(fis);
		String Value = pro.getProperty(Key);
		return Value;		
	}

}
