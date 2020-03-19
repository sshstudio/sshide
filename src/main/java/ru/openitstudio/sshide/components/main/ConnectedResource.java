package ru.openitstudio.sshide.components.main;

public interface ConnectedResource extends AutoCloseable {
    boolean isInitiated();

    boolean isConnected();

    void close();
}
