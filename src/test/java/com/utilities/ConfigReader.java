package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // Bu class configuration.properties fie/dosyadaki bilgileri okumak icindir
    //Properties object olusturulur
    private static Properties properties;

    static {
        //properties file path'i
        String path = "configuration.properties";

        try {
            //fie i ac
            FileInputStream fileInputStream = new FileInputStream((path));
            //properties objecti aktif et
            properties = new Properties();

            //dosyayi yukle
            properties.load(fileInputStream);
            //dosyayi kapat
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // getProperti(key) ==> value

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
        //  return  properties.getProperty(key);
    }
}
