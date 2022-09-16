package com.example.battle_ship.service;

import com.example.battle_ship.model.binding.HomeBindingModel;
import com.example.battle_ship.model.service.ShipServiceModel;
import com.example.battle_ship.model.service.UserServiceModel;
import com.example.battle_ship.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {

    void addShip(ShipServiceModel serviceModel, UserServiceModel currentUser);

    List<ShipViewModel> findAllShips();

    void fight(HomeBindingModel homeBindingModel);
}
