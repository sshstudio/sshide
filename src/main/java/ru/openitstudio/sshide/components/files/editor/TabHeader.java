package ru.openitstudio.sshide.components.files.editor;

import ru.openitstudio.sshide.utils.FontUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TabHeader extends JPanel {
    private JLabel lblTitle, btnClose;

    public TabHeader(String title) {
        super(new BorderLayout(10, 10));
        setOpaque(false);
        lblTitle = new JLabel(title);
        lblTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(lblTitle);
        btnClose = new JLabel();
        btnClose.setFont(FontUtils.getFontAwesomeFont());
        btnClose.setText("\uf00d");
        add(btnClose, BorderLayout.EAST);
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public JLabel getBtnClose() {
        return btnClose;
    }

    public void setTitle(String text) {
        lblTitle.setText(text);
    }
}
