package ru.openitstudio.sshide.components.cron;

import ru.openitstudio.sshide.components.common.DisabledPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CronPanel extends JPanel {

    public CronPanel() {
        super(new BorderLayout());

        JPanel grid = new JPanel(new GridLayout(1, 4, 10, 10));
        grid.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btn1 = new JButton("Ping");
        grid.add(btn1);

//        contentPane = new JPanel(new BorderLayout());
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//        disabledPanel = new DisabledPanel();
//        disabledPanel.startAnimation(stopFlag);
//
//        rootPane = new JRootPane();
//        rootPane.setContentPane(contentPane);
//        add(rootPane);
//
//        rootPane.setGlassPane(disabledPanel);
//
//        contentPane.add(grid, BorderLayout.NORTH);

    }

}
