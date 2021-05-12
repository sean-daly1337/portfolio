package service.impl;

import dto.AgentsDto;
import entities.Agents;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.AgentsRepository;
import service.AgentsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentsServiceImpl implements AgentsService {

    @Autowired
    private AgentsRepository agentsRepository;

    @Override
    public AgentsDto getAgentById(Long agentId) {
        Agents agents = agentsRepository.getAgentById(agentId);

        if (agents == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        AgentsDto retValued = new AgentsDto();
        BeanUtils.copyProperties(agents, retValued);

        return retValued;
    }

    @Override
    public List<AgentsDto> getAgentsList(int page, int limit) {
        List<AgentsDto> returnedValue = new ArrayList<>();

        if (page > 0) page--;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Agents> groupsPage = agentsRepository.findAll(pageableRequest);
        List<Agents> groups = groupsPage.getContent();

        for (Agents e : groups) {
            AgentsDto agentsDto = new AgentsDto();
            BeanUtils.copyProperties(e, agentsDto);

            returnedValue.add(agentsDto);
        }
        return returnedValue;
    }

    @Transactional
    @Override
    public AgentsDto createAgent(AgentsDto agentsDto) {

        Agents agentsEntity = new Agents();
        BeanUtils.copyProperties(agentsDto, agentsEntity);

        Agents storedUserDetails = agentsRepository.save(agentsEntity);
        AgentsDto returnedValue = new AgentsDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }

    @Override
    public void deleteAgent(Long agentId) {
        agentsRepository.deleteById(agentId);
    }

    @Override
    public AgentsDto updateAgent(AgentsDto agentsDto) {

        Agents agentsEntity = new Agents();
        BeanUtils.copyProperties(agentsDto, agentsEntity);

        Agents storedUserDetails = agentsRepository.save(agentsEntity);
        AgentsDto returnedValue = new AgentsDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }
}
