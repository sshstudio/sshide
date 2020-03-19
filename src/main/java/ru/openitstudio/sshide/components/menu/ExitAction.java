package ru.openitstudio.sshide.components.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractAction
{
    private static final long serialVersionUID = 1L;
    public ExitAction() {
        putValue(NAME, "Exit");
    }
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
