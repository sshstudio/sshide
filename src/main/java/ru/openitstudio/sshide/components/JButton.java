package ru.openitstudio.sshide.components;

import ru.openitstudio.sshide.utils.FontUtils;

public class JButton extends javax.swing.JButton {

    public JButton(String text) {
        super(text);
        setFont(FontUtils.getFontMono());
    }

}
