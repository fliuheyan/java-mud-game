package org.cloud.mud.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;

public class ConfigUtils {
    public static Configuration getConversation() throws ConfigurationException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("config/conversation.properties").setEncoding("UTF-8"));
        return builder.getConfiguration();
    }

    public static void main(String[] args) throws ConfigurationException, IOException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("config/conversation.properties").setEncoding("UTF-8"));


        Configuration configuration = builder.getConfiguration();
//        configuration.addProperty("hehe", "234");
        Logger.info(configuration.getString("1"));
//        builder.save();


//        Logger.info("####################");
//        Logger.info(System.getProperty("user.dir"));
//        Properties properties = new Properties();
//        InputStream is = new FileInputStream("config/conversation.properties");
//        properties.load(is);
//        Logger.info(properties.getProperty("0"));

//        Logger.info(getConversation().getString("0"));

    }
}
