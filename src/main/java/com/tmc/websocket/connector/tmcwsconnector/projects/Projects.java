package com.tmc.websocket.connector.tmcwsconnector.projects;

public enum Projects {
    Java("Java"),
    NET(".NET"),
    Go("Go"),
    Py("Python");

    public final String label;

    private Projects(String label) {
        this.label = label;
    }
}
