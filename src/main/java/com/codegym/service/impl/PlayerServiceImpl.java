package com.codegym.service.impl;

import com.codegym.model.Player;
import com.codegym.repository.PlayerRepository;
import com.codegym.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Iterable<Player> findAllByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.delete(id);
    }
}
