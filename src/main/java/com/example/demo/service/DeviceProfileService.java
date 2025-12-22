package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile save(DeviceProfile device);

    List<DeviceProfile> getByUserId(Long userId);

    DeviceProfile getByDeviceId(String deviceId);
}
