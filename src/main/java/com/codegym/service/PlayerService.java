package com.codegym.service;

import com.codegym.model.Player;

public interface PlayerService {

    Iterable<Player> findAllByTeamId(Long teamId);

    Player findById(Long id);

    void save(Player player);

    void delete(Long id);
}
