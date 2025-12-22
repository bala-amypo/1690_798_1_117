package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile save(DeviceProfile device) {
        return deviceRepo.save(device);
    }

    @Override
    public List<DeviceProfile> getByUserId(Long userId) {
        return deviceRepo.findByUserId(userId);
    }

    @Override
    public DeviceProfile getByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }
}
