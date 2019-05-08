package com.game.feignclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Block;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.entity.Player;
import com.game.entity.PlayerBlock;

@RestController
public class AppController {

	@Autowired
	ServiceClient serviceClient;

	@PostMapping("/fetchBlocks")
	public List<Block> fetchBlocks(@RequestBody List<Block> list) {
		return serviceClient.blocks(list);
	}

	@PostMapping("/fetchPlayers")
	public List<Player> fetchPlayers() {
		return serviceClient.playerList();
	}

	@PostMapping("/fetchPlayerBlock")
	public PlayerBlock fetchPlayerBlock(@RequestBody PlayerBlock playerBlock) {
		return serviceClient.playerBlock(playerBlock);
	}

}
