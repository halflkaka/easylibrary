package com.halflkaka.bookapi.models;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Canjie on 2019-01-14 16:32
 */

public class ProjectStatus {
    private String status;
    public ProjectStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
