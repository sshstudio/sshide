package ru.openitstudio.sshide.components.ui;

import ru.openitstudio.sshide.utils.FontUtils;

public class JButton extends javax.swing.JButton {

    public JButton() {
        super();
        setFont(FontUtils.getFontForUi());
    }

    public JButton(String text) {
        super(text);
        setFont(FontUtils.getFontForUi());
    }

}
