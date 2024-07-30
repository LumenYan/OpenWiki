package com.openwiki.back.repository;

import com.openwiki.back.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Games, Long> {
}
