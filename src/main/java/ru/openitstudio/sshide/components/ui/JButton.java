package ru.openitstudio.sshide.components.ui;

import ru.openitstudio.sshide.components.common.CustomButtonPainter;
import ru.openitstudio.sshide.utils.FontUtils;

import javax.swing.*;
import java.awt.*;

public class JButton extends javax.swing.JButton {

    public JButton() {
        super();
        applyTheme();
        setFont(FontUtils.getFontForUi());
    }

    public JButton(String text) {
        super(text);
        applyTheme();
        setFont(FontUtils.getFontForUi());
    }

    private void applyTheme() {
        UIDefaults btnSkin = new UIDefaults();
        Color bgColor = (Color) UIManager.get("Button.background");
        CustomButtonPainter cs = new CustomButtonPainter(bgColor, bgColor, bgColor);
        btnSkin.put("Button[Default+Focused+MouseOver].backgroundPainter", cs.getHotPainter());
        btnSkin.put("Button[Default+Focused+Pressed].backgroundPainter",
                cs.getPressedPainter());
        btnSkin.put("Button[Default+Focused].backgroundPainter",
                cs.getNormalPainter());
        btnSkin.put("Button[Default+MouseOver].backgroundPainter",
                cs.getHotPainter());
        btnSkin.put("Button[Default+Pressed].backgroundPainter",
                cs.getPressedPainter());
        btnSkin.put("Button[Default].backgroundPainter", cs.getNormalPainter());
        btnSkin.put("Button[Enabled].backgroundPainter", cs.getNormalPainter());
        btnSkin.put("Button[Focused+MouseOver].backgroundPainter",
                cs.getHotPainter());
        btnSkin.put("Button[Focused+Pressed].backgroundPainter",
                cs.getPressedPainter());
        btnSkin.put("Button[Focused].backgroundPainter", cs.getNormalPainter());
        btnSkin.put("Button[MouseOver].backgroundPainter", cs.getHotPainter());
        btnSkin.put("Button[Pressed].backgroundPainter",
                cs.getPressedPainter());
        putClientProperty("Nimbus.Overrides", btnSkin);
    }
}
