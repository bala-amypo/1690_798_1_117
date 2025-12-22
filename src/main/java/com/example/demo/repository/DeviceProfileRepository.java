package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceProfile;
import java.util.List;
import java.util.Optional;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    List<DeviceProfile> findByUserId(Long userId);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
