package ru.openitstudio.sshide.components.ui;

import ru.openitstudio.sshide.utils.FontUtils;

import javax.swing.*;

public class JComboBox<E> extends javax.swing.JComboBox<E> {

    public JComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
        setFont(FontUtils.getFontForUi());
    }

    public JComboBox(E[] items) {
        super(items);
        setFont(FontUtils.getFontForUi());
    }

}
