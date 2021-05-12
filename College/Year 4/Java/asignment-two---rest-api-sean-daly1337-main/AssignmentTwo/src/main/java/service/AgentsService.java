package service;

import dto.AgentsDto;

import java.util.List;

public interface AgentsService {

    AgentsDto getAgentById(Long agentId);

    List<AgentsDto> getAgentsList(int page, int limit);

    AgentsDto createAgent(AgentsDto agentsDto);

    void deleteAgent(Long agentId);

    AgentsDto updateAgent(AgentsDto agentsDto);
}
