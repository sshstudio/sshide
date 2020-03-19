package ru.openitstudio.sshide.components.files.logviewer;

public interface SearchListener {
    public void search(String text);
    public void select(long index);
}
