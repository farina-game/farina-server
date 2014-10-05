package net.falsecam.farina_server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author FalseCAM
 */
public class ServerConfig {

    private String name;
    private String host;
    private String port;
    private String gamebrowser;

    public ServerConfig(String file) {
        Properties properties = new Properties();
        InputStream is = null;

        try {

            is = new FileInputStream(file);
            properties.load(is);

            name = properties.getProperty("name");
            host = properties.getProperty("host");
            port = properties.getProperty("port");
            gamebrowser = properties.getProperty("gamebrowser");

        } catch (IOException ex) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getGameBrowser() {
        return gamebrowser;
    }
}
