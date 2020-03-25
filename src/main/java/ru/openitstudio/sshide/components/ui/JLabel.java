package ru.openitstudio.sshide.components.ui;


import ru.openitstudio.sshide.utils.FontUtils;

public class JLabel extends javax.swing.JLabel {

    public JLabel(String text) {
        super(text);
        setFont(FontUtils.getFontForUi());
    }
}
