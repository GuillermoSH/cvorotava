package com.cvorotava.backend.service;

import com.cvorotava.backend.dto.PlayerDto;
import com.cvorotava.backend.entity.Player;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface IPlayerService {
    List<PlayerDto> findAll();

    PlayerDto findById(Integer id);

    List<PlayerDto> findByCategory(String category);

    PlayerDto findByDni(String dni);

    List<PlayerDto> searchLike(String search);

    List<PlayerDto> findAllOrderedBy(String order);

    String[] countPlayers();

    void delete(PlayerDto playerDto);

    void deleteAll();

    PlayerDto save(Player entity);

    PlayerDto uploadImage(Integer id, MultipartFile file);
}
