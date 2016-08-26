package org.cloud.mud.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;

public class ConfigUtils {
    public static PropertiesConfiguration getConversation() throws ConfigurationException {
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new FileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
                        .configure(new Parameters().properties()
                                .setFileName("config/conversation.properties")
                                .setListDelimiterHandler(new DefaultListDelimiterHandler(';'))
                                .setIncludesAllowed(false));
        return builder.getConfiguration();
    }

    public static void main(String[] args) throws ConfigurationException, IOException {
//        Logger.info("####################");
//        Logger.info(System.getProperty("user.dir"));
//        Properties properties = new Properties();
//        InputStream is = new FileInputStream("config/conversation.properties");
//        properties.load(is);
//        Logger.info(properties.getProperty("0"));

        Logger.info(getConversation().getString("0"));
    }
}
