package bsturk.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    //Initialize Log4j instance
    private static Logger Log = LogManager.getLogger(LogUtil.class.getName());

    //Bilgi vermek amaçlı
    public static void info(String message) {
        Log.info(message);
    }

    public static void otherInfo(String message) {
        Log.info(" \t\t\t\t --->"+message);
    }

    //Warn mesajları için
    public static void warn(String message) {
        Log.warn(message);
    }

    //Hataların bildirilmesi için
    public static void error(String message,Object errorMessage) {
        Log.error("Error: "+message+ "\n\t Error Message:"+errorMessage);
    }

    //Ölümcül hataların bildirilmesi için
    public static void fatal(String message) {
        Log.fatal(message);
    }

    //Debug mesajları için
    public static void debug(String message) {
        Log.debug(message);
    }
}
