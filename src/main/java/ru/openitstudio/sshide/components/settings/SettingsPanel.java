package ru.openitstudio.sshide.components.settings;

import ru.openitstudio.sshide.common.IdePanel;
import ru.openitstudio.sshide.common.Settings;
import ru.openitstudio.sshide.components.ui.JButton;
import ru.openitstudio.sshide.components.ui.JCheckBox;
import ru.openitstudio.sshide.components.ui.JComboBox;
import ru.openitstudio.sshide.components.ui.JLabel;
import ru.openitstudio.sshide.utils.SaveAndLoad;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class SettingsPanel extends JPanel {
    private final JCheckBox chkConfirmBeforeDelete;
    private final JCheckBox chkConfirmBeforeMoveOrCopy;
    private final JCheckBox chkShowHiddenFilesByDefault;
    private final JCheckBox chkPromptForSudo;
    private final JCheckBox chkDirectoryCache;
    private final JCheckBox chkShowPathBar;
    private final JCheckBox chkConfirmBeforeTerminalClosing;
    private final JCheckBox chkUseDarkThemeForTerminal;
    private final JCheckBox chkShowMessagePrompt;
    private final JCheckBox chkPuttyLikeCopyPaste;
    private final JComboBox<String> cmbDefaultOpenAction;
    private final JComboBox<String> cmbTermType;
    private final JComboBox<Integer> cmbNumberOfSimultaneousConnection;
    private final JComboBox<String> cmbDefaultPanel;
    private Settings settings;
    private JDialog dlg;
    private final JFrame frame;

    private final JComboBox<String> cmbDefaultTheme;

    public void load(Settings settings) {
        this.settings = settings;
        chkConfirmBeforeDelete.setSelected(settings.isConfirmBeforeDelete());
        chkConfirmBeforeMoveOrCopy.setSelected(settings.isConfirmBeforeMoveOrCopy());
        chkShowHiddenFilesByDefault.setSelected(settings.isShowHiddenFilesByDefault());
        chkPromptForSudo.setSelected(settings.isPromptForSudo());
        chkDirectoryCache.setSelected(settings.isDirectoryCache());
        chkShowPathBar.setSelected(settings.isShowPathBar());
        chkConfirmBeforeTerminalClosing.setSelected(settings.isConfirmBeforeTerminalClosing());
        chkUseDarkThemeForTerminal.setSelected(settings.isUseDarkThemeForTerminal());
        chkPuttyLikeCopyPaste.setSelected(settings.isPuttyLikeCopyPaste());
        chkShowMessagePrompt.setSelected(settings.isShowMessagePrompt());

        cmbDefaultOpenAction.setSelectedIndex(settings.getDefaultOpenAction());
        cmbNumberOfSimultaneousConnection.setSelectedItem(settings.getNumberOfSimultaneousConnection());
        cmbTermType.setSelectedItem(settings.getTerminalType());
        cmbDefaultPanel.setSelectedItem(settings.getDefaultPanel());

        cmbDefaultTheme.setSelectedItem(settings.getTheme());
    }

    public void applySettings() {
        settings.setConfirmBeforeDelete(chkConfirmBeforeDelete.isSelected());
        settings.setConfirmBeforeMoveOrCopy(chkConfirmBeforeMoveOrCopy.isSelected());
        settings.setShowHiddenFilesByDefault(chkShowHiddenFilesByDefault.isSelected());
        settings.setPromptForSudo(chkPromptForSudo.isSelected());
        settings.setDirectoryCache(chkDirectoryCache.isSelected());
        settings.setShowPathBar(chkShowPathBar.isSelected());
        settings.setConfirmBeforeTerminalClosing(chkConfirmBeforeTerminalClosing.isSelected());
        settings.setUseDarkThemeForTerminal(chkUseDarkThemeForTerminal.isSelected());
        settings.setPuttyLikeCopyPaste(chkPuttyLikeCopyPaste.isSelected());
        settings.setShowMessagePrompt(chkShowMessagePrompt.isSelected());

        settings.setDefaultOpenAction(cmbDefaultOpenAction.getSelectedIndex());
        settings.setNumberOfSimultaneousConnection((Integer) cmbNumberOfSimultaneousConnection.getSelectedItem());
        settings.setTerminalType((String) cmbTermType.getSelectedItem());
        settings.setDefaultPanel((String) cmbDefaultPanel.getSelectedItem());
        settings.setTheme((String) cmbDefaultTheme.getSelectedItem());
    }

    private String[] getThemesList() {

        File path = new File(System.getProperty("user.home") +
                File.separator +
                ".sshide" +
                File.separator +
                "themes");

        ArrayList<String> result = new ArrayList<>();

        try {
            for (final File fileEntry : path.listFiles()) {
                if (!fileEntry.isDirectory()) {
                    result.add(fileEntry.getName());
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return result.toArray(new String[0]);
    }

    public SettingsPanel(JFrame frame) {
        super(new BorderLayout());
        this.frame = frame;
        chkConfirmBeforeDelete = new JCheckBox("Confirm before deleting files");
        chkConfirmBeforeMoveOrCopy = new JCheckBox("Confirm before moving or copying files");
        chkShowHiddenFilesByDefault = new JCheckBox("Show hidden files by default");
        chkPromptForSudo = new JCheckBox("Prompt for sudo if operation fails due to permission issues");
        chkDirectoryCache = new JCheckBox("Use directory caching");
        chkShowPathBar = new JCheckBox("Show current folder in path bar style");
        chkConfirmBeforeTerminalClosing = new JCheckBox("Confirm before closing a terminal session");
        chkUseDarkThemeForTerminal = new JCheckBox("Use dark terminal theme");
        chkPuttyLikeCopyPaste = new JCheckBox("Use PuTTY like copy paste for terminal");
        chkShowMessagePrompt = new JCheckBox("Show message prompt");

        cmbDefaultOpenAction = new JComboBox<>(new String[]{"Open with default application", "Open with default editor", "Open with internal editor"});
        cmbDefaultOpenAction.setMaximumSize(cmbDefaultOpenAction.getPreferredSize());
        cmbNumberOfSimultaneousConnection = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        cmbNumberOfSimultaneousConnection.setMaximumSize(new Dimension(cmbDefaultOpenAction.getPreferredSize().width * 2, cmbDefaultOpenAction.getPreferredSize().height));
        cmbTermType = new JComboBox<>(new String[]{"vt100", "xterm", "xterm-256color"});
        cmbTermType.setMaximumSize(new Dimension(cmbTermType.getPreferredSize().width * 2, cmbTermType.getPreferredSize().height));
        cmbDefaultPanel = new JComboBox<>(Arrays.stream(IdePanel.values()).map(it -> it.getName()).toArray(String[]::new));
        cmbDefaultPanel.setMaximumSize(new Dimension(cmbDefaultPanel.getPreferredSize().width * 2, cmbDefaultPanel.getPreferredSize().height));
        cmbDefaultTheme = new JComboBox<>(getThemesList());
        cmbDefaultTheme.setMaximumSize(new Dimension(cmbDefaultTheme.getPreferredSize().width * 2, cmbDefaultTheme.getPreferredSize().height));


//        Box hb1 = Box.createHorizontalBox();
//        hb1.add(new JLabel("Default action for double click on files"));
//        hb1.add(Box.createHorizontalGlue());
//        hb1.add(cmbDefaultOpenAction);

        Box hb2 = Box.createHorizontalBox();
        hb2.add(new JLabel("Number of simultaneous connection for background file transfer"));
        hb2.add(Box.createHorizontalGlue());
        hb2.add(cmbNumberOfSimultaneousConnection);

        Box hb3 = Box.createHorizontalBox();
        hb3.add(new JLabel("Terminal type"));
        hb3.add(Box.createHorizontalGlue());
        hb3.add(cmbTermType);

        Box hb4 = Box.createHorizontalBox();
        hb4.add(new JLabel("Default panel"));
        hb4.add(Box.createHorizontalGlue());
        hb4.add(cmbDefaultPanel);
        Box hb5 = Box.createHorizontalBox();
        hb5.add(new JLabel("Default theme"));
        hb5.add(Box.createHorizontalGlue());
        hb5.add(cmbDefaultTheme);

        Box vbox = Box.createVerticalBox();
        chkConfirmBeforeDelete.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkConfirmBeforeMoveOrCopy.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkShowHiddenFilesByDefault.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkPromptForSudo.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkDirectoryCache.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkShowPathBar.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkConfirmBeforeTerminalClosing.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkUseDarkThemeForTerminal.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkShowMessagePrompt.setAlignmentX(Box.LEFT_ALIGNMENT);
        chkPuttyLikeCopyPaste.setAlignmentX(Box.LEFT_ALIGNMENT);
//        hb1.setAlignmentX(Box.LEFT_ALIGNMENT);
        hb2.setAlignmentX(Box.LEFT_ALIGNMENT);
        hb3.setAlignmentX(Box.LEFT_ALIGNMENT);
        hb4.setAlignmentX(Box.LEFT_ALIGNMENT);
        hb5.setAlignmentX(Box.LEFT_ALIGNMENT);
        vbox.add(chkConfirmBeforeDelete);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkConfirmBeforeMoveOrCopy);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkShowHiddenFilesByDefault);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkPromptForSudo);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkDirectoryCache);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkShowPathBar);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkConfirmBeforeTerminalClosing);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkUseDarkThemeForTerminal);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkPuttyLikeCopyPaste);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(chkShowMessagePrompt);
//        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
//        vbox.add(hb1);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(hb2);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(hb3);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(hb5);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.add(hb4);
        vbox.add(Box.createRigidArea(new Dimension(10, 10)));
        vbox.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(vbox);

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        btnOK.addActionListener(e -> {
            applySettings();
            SaveAndLoad.saveSettings();
            dlg.setVisible(false);
        });
        btnCancel.addActionListener(e -> {
            dlg.setVisible(false);
        });
        box.add(btnOK);
        box.add(Box.createHorizontalStrut(10));
        box.add(btnCancel);
        box.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(box, BorderLayout.SOUTH);

        dlg = new JDialog(frame);
        dlg.setTitle("Settings");
        dlg.add(this);
        dlg.setModal(true);
        dlg.setSize(640, 510);

        getRootPane().registerKeyboardAction(e -> {
            dlg.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public void showDialog(Settings settings) {
        load(settings);
        dlg.setLocationRelativeTo(frame);
        dlg.setVisible(true);
    }
}
