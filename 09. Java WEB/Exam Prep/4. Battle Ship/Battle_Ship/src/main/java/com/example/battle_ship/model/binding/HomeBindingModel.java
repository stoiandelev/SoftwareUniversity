package com.example.battle_ship.model.binding;

import javax.validation.constraints.NotNull;

public class HomeBindingModel {

    @NotNull
    private Long attackerShipId;

    @NotNull
    private Long defenderShipId;

    public HomeBindingModel() {
    }

    public Long getAttackerShipId() {
        return attackerShipId;
    }

    public HomeBindingModel setAttackerShipId(Long attackerShipId) {
        this.attackerShipId = attackerShipId;
        return this;
    }

    public Long getDefenderShipId() {
        return defenderShipId;
    }

    public HomeBindingModel setDefenderShipId(Long defenderShipId) {
        this.defenderShipId = defenderShipId;
        return this;
    }
}
