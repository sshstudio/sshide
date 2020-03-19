package ru.openitstudio.sshide.components.main;

import ru.openitstudio.sshide.components.newsession.SessionInfo;

public class SessionHolder {
    private SessionInfo info;

    public SessionHolder(SessionInfo info){
        this.info=info;
    }

    @Override
    public String toString() {
        return info.getName();
    }

    public void close(){

    }
}
