package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int countExplorerPlanet;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();

    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        //var args argument,за items
       // planet.getItems().addAll(Arrays.asList(items));
        planet.getItems().addAll(Arrays.asList(items));

        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.getModels().stream().noneMatch(a -> a.getName().equals(astronautName))) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        //трябва да го намерим в репоситорито по име;
        Astronaut removeAstronaut = this.astronautRepository.findByName(astronautName);
        this.astronautRepository.remove(removeAstronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        //всички с кислород над 60
        List<Astronaut> suitableAstronault = this.astronautRepository.getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (suitableAstronault.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int countBeforeMission = suitableAstronault.size();

        //Стартираме мисията
        Mission mission = new MissionImpl();
        //Откриваме планетата
        Planet planet = this.planetRepository.findByName(planetName);
        mission.explore(planet, suitableAstronault);
        countExplorerPlanet++;

        int countAfterMission = suitableAstronault.size();

        return String.format(PLANET_EXPLORED, planetName, countBeforeMission - countAfterMission);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.
                append(String.format(REPORT_PLANET_EXPLORED, countExplorerPlanet))
                .append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        this.astronautRepository.getModels().forEach(a -> {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, a.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, a.getOxygen()))
                    .append(System.lineSeparator());

            if (a.getBag().getItems().size() == 0) {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"))
                        .append(System.lineSeparator());
            } else {
                Collection<String> items = a.getBag().getItems();
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(", ", items)))
                        .append(System.lineSeparator());
            }

        });

        return sb.toString().trim();
    }


}
