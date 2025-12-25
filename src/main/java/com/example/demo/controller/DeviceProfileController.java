package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(
            @PathVariable Long id,
            @RequestParam boolean trust) {
        return ResponseEntity.ok(service.updateTrustStatus(id, trust));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        return ResponseEntity.ok(
                service.findByDeviceId(deviceId).orElse(null)
        );
    }
}
