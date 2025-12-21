package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    List<DeviceProfile> findByUserId(Long userId);
}
