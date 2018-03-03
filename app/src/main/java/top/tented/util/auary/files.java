package top.tented.util.auary;

import java.io.*;
import java.util.*;

/**
 * Created by XYT on 2018/3/3.
 */

public class files
{
    public boolean condition = false;

    public String content = null;

    public StringBuffer name = new StringBuffer();

    public String get(){
        File[] root = File.listRoots();

        for(File file : root)
        {
            return file.getAbsolutePath();
        }
        return null;
    }
    public void read(String msg) {
        Properties prop = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(get()+"Thesaurus.properties"));
            prop.load(in);
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                if (key.contains(msg)){
                    condition = true;
                    content = prop.getProperty(key);
                    break;
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Enumeration enum1 = prop.propertyNames();
     name.append(enum1);
     */
    public void add(String name,String msg)
    {
        Properties prop = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(get()+"Thesaurus.properties"));
            prop.load(in);
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                if (key.contains(msg)){
                    condition = true;
                    content = prop.getProperty(key);
                    break;
                }

                    in = new BufferedInputStream(new FileInputStream(get() + "Thesaurus.properties"));
                    prop.load(in);

            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
