package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class DeviceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String deviceId;
    private String deviceType;
    private String osVersion;
    private LocalDateTime lastseen;
    private Boolean isTrusted;
    public DeviceProfile() {
    }
    public DeviceProfile(long userId, String deviceId, String deviceType, String osVersion, LocalDateTime lastseen,
            Boolean isTrusted) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.lastseen = lastseen;
        this.isTrusted = isTrusted;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getOsVersion() {
        return osVersion;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public LocalDateTime getLastseen() {
        return lastseen;
    }
    public void setLastseen(LocalDateTime lastseen) {
        this.lastseen = lastseen;
    }
    public Boolean getIsTrusted() {
        return isTrusted;
    }
    public void setIsTrusted(Boolean isTrusted) {
        this.isTrusted = isTrusted;
    }
    


}