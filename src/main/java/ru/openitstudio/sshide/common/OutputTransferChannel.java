package ru.openitstudio.sshide.common;

import java.io.Closeable;
import java.io.OutputStream;

public interface OutputTransferChannel extends Closeable {
    OutputStream getOutputStream(String path) throws Exception;
    String getSeparator();
    void close();
}
