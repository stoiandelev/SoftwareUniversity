package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {

        //пускаме цикъл по всички астронавти
        for (int index = 0; index < astronauts.size(); index++) {
            Astronaut currentAstronault = astronauts.get(index);
            //взимаме всички item на планетата
            for (int item = 0; item < planet.getItems().size(); item++) {
                String currentItem = planet.getItems().get(item);
                //текущия астронафт взими чантата, вземи итема и добави текущия итем
                currentAstronault.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                item--;
                currentAstronault.breath();
                //проверка дали астронафта може да диша
                if (!currentAstronault.canBreath()) {
                    astronauts.remove(currentAstronault);
                    //за да вземем следващия и намалим размера
                    index--;
                    break;
                }
            }
        }
    }
}
