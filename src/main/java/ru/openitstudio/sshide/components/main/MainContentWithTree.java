package ru.openitstudio.sshide.components.main;

import javax.swing.*;
import java.awt.*;

public class MainContentWithTree extends JPanel {
    private JFrame frame;

    public MainContentWithTree(JFrame frame) {
        super(new BorderLayout(0, 0));
        this.frame = frame;
//        gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(200, 200, 200),
//                0.0f, 50.0f, new Color(150, 150, 150));
        init();
    }

    private void init() {
        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                sessionsTreePanel(), workPanel());
        add(pane);
    }

    public JPanel sessionsTreePanel() {
        return new ConnectionsTree();
    }

    public JPanel workPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(10, 100, 80));
        panel.add(new MainContent(frame));
        return panel;
    }
}
