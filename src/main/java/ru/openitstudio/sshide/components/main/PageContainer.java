package ru.openitstudio.sshide.components.main;

import java.awt.*;

public interface PageContainer {

    void selectPage(int index);

    Component getPageComponent();

    Component getPageContent();

    int getSelectedPage();
}
