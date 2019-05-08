package com.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.entity.Block;
import com.game.entity.Player;
import com.game.entity.PlayerBlock;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/blocks")
	public List<Block> blocks(@RequestBody List<Block> list) {
		return gameService.placeMove(list);
	}

	@PostMapping("/players")
	public List<Player> playerList() {
		return gameService.playerList();
	}

	@PostMapping("/playerBlock")
	public PlayerBlock playerBlock(@RequestBody PlayerBlock playerBlock) {
		return gameService.playerBlockService(playerBlock);
	}

}
