package net.falsecam.farina_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FalseCAM
 */
public class GameBrowser {

    private ServerConfig serverConfig;
    private String gameBrowserKey;

    public GameBrowser(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    public boolean login() {
        try {
            URL url = new URL("http://" + serverConfig.getGameBrowser() + "/login");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write("name=" + serverConfig.getName() + "&host=" + serverConfig.getHost()
                    + "&port=" + serverConfig.getPort());
            writer.flush();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                if (line.contains("key=")) {
                    this.gameBrowserKey = line.replace("key=", "");
                }
            }
            writer.close();
            reader.close();


        } catch (Exception ex) {
            Logger.getLogger(GameBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public String getGameBrowserKey() {
        return gameBrowserKey;
    }
}
