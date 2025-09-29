package ru.openitstudio.sshide.components.ui;

import ru.openitstudio.sshide.App;
import ru.openitstudio.sshide.components.main.AppInfoDialog;
import ru.openitstudio.sshide.components.main.MainContent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MacOSApplication {

    public static void initMacApplication(Component mainContent) throws IOException {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "SshIde");

        Desktop desktop = Desktop.getDesktop();

        desktop.setAboutHandler(event -> {
            new AppInfoDialog(SwingUtilities.windowForComponent(mainContent)).setVisible(true);
        });

        desktop.setPreferencesHandler(event -> {
            MainContent mc = (MainContent) mainContent;
            mc.getSettingsPanel().showDialog(App.getGlobalSettings());
        });
    }

}
