package com.game.feignclient;

import java.util.List;

import org.springframework.cglib.core.Block;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.game.entity.Player;
import com.game.entity.PlayerBlock;

@FeignClient(name = "game-service")
public interface ServiceClient {

	@PostMapping("/blocks")
	public List<Block> blocks(@RequestBody List<Block> list);

	@PostMapping("/players")
	public List<Player> playerList();

	@PostMapping("/playerBlock")
	public PlayerBlock playerBlock(@RequestBody PlayerBlock playerBlock);
}
