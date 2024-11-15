package Utilities;

import org.apache.logging.log4j.LogManager;

public class LogUtilites {
    public static void info(String msg){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).info(msg);

    }
    public static void Error(String msg){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).error(msg);
    }
}
