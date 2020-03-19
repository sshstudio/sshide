package ru.openitstudio.sshide.components.menu;

import ru.openitstudio.sshide.App;
import ru.openitstudio.sshide.components.settings.SettingsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {

    private JFrame parentFrame;

    public MenuBar(JFrame frame)
    {
        parentFrame = frame;
    }

    public JMenuBar create() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        return menuBar;
    }

    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("File");
        // Пункт меню "Открыть" с изображением
        JMenuItem settings = new JMenuItem("Settings");




        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem(new ExitAction());
        // Добавление к пункту меню изображения
        exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open
        file.add(settings);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        settings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SettingsPanel sp = new SettingsPanel(parentFrame);
                sp.showDialog(App.getGlobalSettings());
            }
        });
        return file;
    }
}
