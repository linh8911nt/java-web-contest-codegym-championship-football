package com.codegym.repository;

import com.codegym.model.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
    Iterable<Player> findAllByTeamId(Long teamId);
}
