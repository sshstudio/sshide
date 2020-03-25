package ru.openitstudio.sshide.components.main;

import ru.openitstudio.sshide.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppInfoDialog extends JDialog {
    public AppInfoDialog(Window window) {
        super(window);
        setModal(true);
        JLabel lblIcon = new JLabel(new ImageIcon(getClass().getResource("/logo-256.png")));
        lblIcon.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(lblIcon, BorderLayout.NORTH);

        JLabel lblTitle = new JLabel("SshIde");
        lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        JLabel lblVersion = new JLabel("v"+App.APP_VERSION_STR);
        JLabel lblAuthor = new JLabel("Fedor B Gorsky");

        lblTitle.setAlignmentX(Box.CENTER_ALIGNMENT);
        lblVersion.setAlignmentX(Box.CENTER_ALIGNMENT);
        lblAuthor.setAlignmentX(Box.CENTER_ALIGNMENT);

        Box vbox = Box.createVerticalBox();
        vbox.add(lblTitle);
        vbox.add(lblVersion);
        vbox.add(lblAuthor);

        add(vbox);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(bottomPanel, BorderLayout.SOUTH);

        setSize(640, 480);
        setLocationRelativeTo(null);
    }
}
