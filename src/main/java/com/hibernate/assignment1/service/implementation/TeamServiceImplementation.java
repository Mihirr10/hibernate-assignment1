package com.hibernate.assignment1.service.implementation;

import com.hibernate.assignment1.entities.Player;
import com.hibernate.assignment1.entities.Team;
import com.hibernate.assignment1.exception.TeamNotFound;
import com.hibernate.assignment1.repository.TeamRepository;
import com.hibernate.assignment1.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImplementation implements TeamService {

  @Autowired
  TeamRepository teamRepository;

  @Override
  public List<Team> getAllTeams() {
    return teamRepository.findAll();
  }

  @Override
  public Team getTeamWithId(int id) {
    Optional<Team> team = teamRepository.findById(id);

    if (team.isPresent()) {
      return teamRepository.save(team.get());
    } else {
      throw new TeamNotFound("Please enter valid team id");
    }
  }

  @Override
  public Team createTeam(Team team) {

    if (team != null) {
      List<Player> player = team.getPlayers();
      List<Player> collect = player.stream().map(i -> {
        i.setTeam(team);
        return i;
      }).collect(Collectors.toList());
      team.setPlayers(collect);
      return teamRepository.save(team);
    } else {
      throw new TeamNotFound("failed to create team please enter valid details");
    }

  }

  @Override
  public Team updateTeam(Team team, int id) {

    Team team1 = teamRepository.findById(id).orElse(null);
    if (team1 == null) {
      throw new TeamNotFound("team not found");
    } else {
      team.setTeamId(id);
    }
    return teamRepository.save(team);
  }

  @Override
  public void deleteTeam(int id) {
    Optional<Team> team = teamRepository.findById(id);

    if (team.isPresent()) {
      teamRepository.delete(team.get());
    } else {
      throw new TeamNotFound("failed to delete student please enter valid id");
    }
  }
}
