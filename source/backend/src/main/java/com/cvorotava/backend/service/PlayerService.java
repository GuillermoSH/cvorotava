package com.cvorotava.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cvorotava.backend.entity.Player;
import com.cvorotava.backend.repository.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerrepository;

	public Player save(Player entity) {
		return playerrepository.save(entity);
	}
	
	public Integer countPlayers() {
		return playerrepository.countPlayers();
	}

	public Player findById(Integer id) {
		return playerrepository.findById(id).get();
	}
	
	public Player findByDni(String dni) {
		return playerrepository.findByDni(dni).get();
	}

	public List<Player> findAll() {
		return playerrepository.findAll(PageRequest.of(0, 20)).getContent();
	}
	
	public List<Player> findAllOrderedBy(String order) {
		if (order.equals("surnames")) {
			return playerrepository.findAllOrderedBy(Sort.by("surname1", "surname2", "name"));
		} else if(order.equals("name")) {
			return playerrepository.findAllOrderedBy(Sort.by("name", "surname1", "surname2"));
		} else {
			return playerrepository.findAllOrderedBy(Sort.by(order));
		}
	}
	
	public List<Player> searchLike(String search) {
		return playerrepository.searchLike(search);
	}

	public Boolean remove(Integer id) {
		Optional<Player> currentUser = playerrepository.findById(id);
		if (currentUser.isPresent()) {
			playerrepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Player> findByCategory(String category) {
		return playerrepository.findByCategory(category);
	}
}