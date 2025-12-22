@Entity
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String deviceId;
    private boolean isTrusted;
    private LocalDateTime lastSeen;

    public String getDeviceId() {
        return deviceId;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setIsTrusted(boolean trusted) {
        this.isTrusted = trusted;
    }
}
