package Libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//comment
/*multi line comment*/
/**
 * This class consist of generic method to read data from property file
 * @author hp
 *
 */
public class propertyfileutility {
	/**
	 * this method is created to read data from prop file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readdatafrompropertiesfile(String key) throws IOException
{
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(f);
		String value=p.getProperty(key);
		return value;
}
}
