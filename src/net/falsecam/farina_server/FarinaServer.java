/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.falsecam.farina_server;

/**
 *
 * @author FalseCAM
 */
public class FarinaServer {

    ServerConfig serverConfig;
    GameBrowser gameBrowser;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FarinaServer();


    }

    FarinaServer() {
        serverConfig = new ServerConfig("farinaserver.cfg");
        gameBrowser = new GameBrowser(serverConfig);
        if (gameBrowser.login()) {
            System.out.println(gameBrowser.getGameBrowserKey());
        }

    }
}
