package com.example.battle_ship.service.impl;

import com.example.battle_ship.model.binding.HomeBindingModel;
import com.example.battle_ship.model.entity.Ship;
import com.example.battle_ship.model.entity.UserEntity;
import com.example.battle_ship.model.service.ShipServiceModel;
import com.example.battle_ship.model.service.UserServiceModel;
import com.example.battle_ship.model.view.ShipViewModel;
import com.example.battle_ship.repository.ShipRepository;
import com.example.battle_ship.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addShip(ShipServiceModel serviceModel, UserServiceModel currentUser) {

        Ship newShip = modelMapper.map(serviceModel, Ship.class);

        newShip.setUser(modelMapper.map(currentUser, UserEntity.class));

        shipRepository.save(newShip);
    }

    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAll().stream().map(s -> modelMapper.map(s, ShipViewModel.class))
                .sorted(Comparator.comparing(ShipViewModel::getName))
                .sorted(Comparator.comparing(ShipViewModel::getHealth))
                .sorted(Comparator.comparing(ShipViewModel::getPower))
                .collect(Collectors.toList());


    }

    @Override
    public void fight(HomeBindingModel homeBindingModel) {

        Optional<Ship> attacker = shipRepository.findById(homeBindingModel.getAttackerShipId());
        Optional<Ship> defender = shipRepository.findById(homeBindingModel.getDefenderShipId());

        if (attacker.isEmpty() || defender.isEmpty()) {
            return;
        }

        Ship defenderShip = defender.get();

        defenderShip.setHealth(defenderShip.getHealth() - attacker.get().getPower());

        if (defenderShip.getHealth() <= 0) {
            shipRepository.delete(defenderShip);
            return;
        }

        shipRepository.save(defenderShip);
    }
}
