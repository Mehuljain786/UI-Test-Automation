package core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class Props {
    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
    private static Properties environmentProps;


    /**
     * Gets the key from messages.properties for a Site
     *
     * @param key
     **/
    public static String getMessage(String key) {

        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return ResourceBundle.getBundle("props/messages").getString(key);

        }
    }
    
    /**
    * Gets the key from Config.properties related to chosen profile
    *
    * @param key
    **/

   public static String getProp(String key) {
       if ((key == null) || key.isEmpty()) {
           return "";
       } else {
           return environmentProps.getProperty(key);

       }
    }
   
    /**
     * Gets the key from System properties defined
     *
     * @param key
     **/

    public static String getSystemProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return System.getProperty(key);
        }
    }


	public static void loadRunConfigProps(String configPropertyFileLocation) {
	
        environmentProps = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(configPropertyFileLocation)) {
            environmentProps.load(inputStream);
            environmentProps.list(out);
            LOG.info("loadRuConfigProps "+environmentProps.toString());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }


}

