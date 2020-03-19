package ru.openitstudio.sshide.components.files.browser.folderview;

import ru.openitstudio.sshide.common.FileInfo;

import javax.swing.*;

public interface FolderViewEventListener {
    void addBack(String path);

    void render(String path);

    void render(String path, boolean useCache);

    void openApp(FileInfo file);

    boolean createMenu(JPopupMenu popupMenu, FileInfo[] files);

    void install(JComponent c);

    void reload();
}
