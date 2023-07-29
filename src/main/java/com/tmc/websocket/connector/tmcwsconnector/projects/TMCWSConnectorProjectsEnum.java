package com.tmc.websocket.connector.tmcwsconnector.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TMCWSConnectorProjectsEnum {
    public ArrayList<String> getAllProjectNames(){
        ArrayList<String> projects = new ArrayList<>();
        for (Projects project: Projects.values()
             ) {
            projects.add(project.label);
        }
        return projects;
    }
    

}
