package com.halflkaka.bookapi.models;


/**
 * Created by Canjie on 2019-01-14 16:32
 */

//HttpResponse Status
public class ProjectStatus {
    private String status;
    public ProjectStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
