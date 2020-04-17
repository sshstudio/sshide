package ru.openitstudio.sshide.components.ui;

import com.apple.eawt.Application;
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

        Application application = Application.getApplication();

        application.setDockIconImage(ImageIO.read(App.class.getResource("/logo-512.png")));

        application.setAboutHandler(event -> {
            new AppInfoDialog(SwingUtilities.windowForComponent(mainContent)).setVisible(true);
        });

        application.setPreferencesHandler(event -> {
            MainContent mc = (MainContent) mainContent;
            mc.getSettingsPanel().showDialog(App.getGlobalSettings());
        });
    }

}
