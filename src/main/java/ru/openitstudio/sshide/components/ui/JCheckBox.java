package ru.openitstudio.sshide.components.ui;

import ru.openitstudio.sshide.utils.FontUtils;

public class JCheckBox extends javax.swing.JCheckBox {

    public JCheckBox(String text) {
        super(text);
        setFont(FontUtils.getFontForUi());
    }
}
