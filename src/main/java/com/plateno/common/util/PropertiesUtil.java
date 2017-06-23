package com.plateno.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 读取properties文件的工具类
 *
 * @author jicexosl
 */
public final class PropertiesUtil {

    private static ResourceBundle globalBundle;
    private static ResourceBundle httpUrlBundle;
    private static ResourceBundle redisKeyBundle;
    private static ResourceBundle dataResourceBundle;
    private static ResourceBundle pushBundle;
    private static ResourceBundle intelligentHotelBundle;


    private PropertiesUtil() {

    }

    static {
        try {
            globalBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/plateno.properties"))));
            httpUrlBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/seven_url.properties"))));
            redisKeyBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/redis_key.properties"))));
            dataResourceBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/datasource.properties"))));
            pushBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/push.properties"))));
            intelligentHotelBundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream(new File("config/intelligent_hotel_config.properties"))));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getGlobalConfig(String key) {
        return globalBundle.getString(key);
    }

    public static String getUrlConfig(String key) {
        return httpUrlBundle.getString(key);
    }

    public static String getRedisKeyConfig(String key) {
        return redisKeyBundle.getString(key);
    }


    public static String getDataSourceConfig(String key) {
        return dataResourceBundle.getString(key);
    }


    public static String getPushConfig(String key) {
        return pushBundle.getString(key);
    }

    public static String getIntelligentHotelConfig(String key) {
        return intelligentHotelBundle.getString(key);
    }
}
