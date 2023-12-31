package com.hibernate.assignment1.service;

import com.hibernate.assignment1.dto.PlayerDto;
import com.hibernate.assignment1.entities.Player;

import java.util.List;

public interface PlayerService {

  public List<PlayerDto> getPlayerWithTeam();

  public List<Player> getAllPlayers();

  public Player getPlayerWithId(int id);

  public Player createPlayer(Player player);

  public Player updatePlayer(Player player, int id);

  public void deletePlayer(int id);
}
