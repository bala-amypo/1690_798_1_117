@Entity
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private String severity;
    private String conditionsJson;
    private Boolean active;

    public String getRuleCode() {
        return ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getConditionsJson() {
        return conditionsJson;
    }

    public Boolean getActive() {
        return active;
    }
}
