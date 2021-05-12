package models.requests;

public class AgentsDeleteRequestModel {

    private Long agentId;

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "AgentsDeleteRequestModel{" +
                "agentId=" + agentId +
                '}';
    }
}
