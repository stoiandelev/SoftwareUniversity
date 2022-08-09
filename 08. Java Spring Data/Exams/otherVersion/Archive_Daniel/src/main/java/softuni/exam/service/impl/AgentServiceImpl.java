package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentRootSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {

    private static final String AGENT_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public AgentServiceImpl(AgentRepository agentRepository, TownService townService, ModelMapper modelMapper,
                            Gson gson, ValidationUtil validationUtil) {
        this.agentRepository = agentRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentRootSeedDto[].class)).filter(agentRootSeedDto -> {

            boolean isValid = validationUtil.isValid(agentRootSeedDto)
                    && !agentRepository.existsByFirstName(agentRootSeedDto.getFirstName());

            stringBuilder.append(isValid ? String.format("Successfully imported agent - %s %s",
                            agentRootSeedDto.getFirstName(), agentRootSeedDto.getLastName()) : "Invalid agent")
                    .append(System.lineSeparator());


            return isValid;
        }).map(agentRootSeedDto -> {

            Agent agent = modelMapper.map(agentRootSeedDto, Agent.class);
            agent.setTown(townService.findTownByName(agentRootSeedDto.getTown()));

            return agent;
        }).forEach(agentRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public Agent findAgent(String name) {
        return agentRepository.findByFirstName(name);
    }

    @Override
    public boolean findAgentByFirstName(String name) {
        return agentRepository.existsByFirstName(name);
    }
}
