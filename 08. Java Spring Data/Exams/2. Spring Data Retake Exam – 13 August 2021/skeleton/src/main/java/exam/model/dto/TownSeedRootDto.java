package exam.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownSeedRootDto {

    @XmlElement(name = "town")
    List<TownSeedDto> towns;



    public List<TownSeedDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownSeedDto> towns) {
        this.towns = towns;
    }
}
