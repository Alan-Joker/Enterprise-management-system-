package com.itcast.domain;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {

    private Integer id;
    private String permissionName; //权限名
    private String url;//资源路径
    private List<UserInfo> roles;

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<UserInfo> roles) {
        this.roles = roles;
    }
}
