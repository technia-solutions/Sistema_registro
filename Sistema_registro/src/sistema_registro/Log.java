/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Carlos
 */
public class Log {
    public Logger logger;
    FileHandler fh;
     
    public Log(String fileName) throws SecurityException, IOException{
        File f = new File(fileName);
        if(!f.exists()){
            f.createNewFile();
        }
        fh = new FileHandler(fileName,true);
        logger = Logger.getLogger("test");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
