package com.game.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.game.entity.Block;
import com.game.entity.Player;
import com.game.entity.PlayerBlock;

@Service
public class GameService {

	private static final int ROWS = 10;
	private static final int COLS = 10;
	private Player activePlayer;
	private int turn = 0;

	public List<Block> placeMove(List<Block> list) {
		List<Block> listTmp = new ArrayList<>(list);

		checkRows(listTmp);
		checkCols(listTmp);
		checkDiag(listTmp);

		return listTmp;

	}

	/**
	 * check rows
	 * 
	 * @param list
	 * @return
	 */
	public List<Block> checkRows(List<Block> list) {

		for (int i = 0; i < list.size(); i++) {

			if (i + 1 > list.size()) {
				break;
			}

			if (i + 2 > list.size()) {
				break;
			}

			if (i >= ROWS * COLS) {
				break;
			}

			if (list.get(i).getVal().equals("S") && list.get(i + 1).getVal().equals("O")
					&& list.get(i + 2).getVal().equals("S")) {

				if ((i + 2) % 10 == 0) {
				} else {

					list.get(i).setStyle(activePlayer.getStyle());
					list.get(i + 1).setStyle(activePlayer.getStyle());
					list.get(i + 2).setStyle(activePlayer.getStyle());

					if (list.get(i).getPlayer() == null || list.get(i + 1).getPlayer() == null
							|| list.get(i + 2).getPlayer() == null) {

						activePlayer.setScore(activePlayer.getScore() + 1);
						list.get(i).setPlayer(activePlayer);
						list.get(i + 1).setPlayer(activePlayer);
						list.get(i + 2).setPlayer(activePlayer);
					}

				}

			}
		}

		return list;
	}

	/**
	 * check cols
	 * 
	 * @param list
	 * @return
	 */
	public List<Block> checkCols(List<Block> list) {

		for (int i = 0; i < list.size(); i++) {

			if ((i + ROWS) > list.size()) {
				break;
			}
			if ((ROWS * 2) > list.size()) {
				break;
			}

			if (i >= ROWS * COLS) {
				break;
			}

			if (list.get(i).getVal().equals("S") && list.get(i + ROWS).getVal().equals("O")
					&& list.get(i + (ROWS * 2)).getVal().equals("S")) {

				if (i + (ROWS - 1) % 10 == 0) {
				} else {

					list.get(i).setStyle(activePlayer.getStyle());
					list.get(i + (ROWS * 1)).setStyle(activePlayer.getStyle());
					list.get(i + (ROWS * 2)).setStyle(activePlayer.getStyle());

					if (list.get(i + (ROWS * 2)).getPlayer() == null || list.get(i).getPlayer() == null
							|| list.get(i + (ROWS * 1)).getPlayer() == null) {

						activePlayer.setScore(activePlayer.getScore() + 1);

						list.get(i + (ROWS * 2)).setPlayer(activePlayer);
						list.get(i).setPlayer(activePlayer);
						list.get(i + (ROWS * 1)).setPlayer(activePlayer);
					}

				}

			}
		}

		return list;
	}

	/**
	 * check Diag.
	 * 
	 * @param list
	 * @return
	 */
	public List<Block> checkDiag(List<Block> list) {

		for (int i = 0; i < list.size(); i++) {

			if ((ROWS + 1)> list.size()) {
				break;
			}

			if ((i + (ROWS + 1) * 2) > list.size()) {
				break;
			}

			if ((i + (ROWS + 1)) % 10 == 0) {

			} else {

				if (list.get(i).getVal().equals("S") && list.get(i + (ROWS + 1)).getVal().equals("O")
						&& list.get(i + (ROWS + 1) * 2).getVal().equals("S")) {
					if (i + (ROWS - 1) % 10 == 0) {

					} else {

						list.get(i).setStyle(activePlayer.getStyle());
						list.get(i + ((ROWS + 1) * 1)).setStyle(activePlayer.getStyle());
						list.get(i + ((ROWS + 1) * 2)).setStyle(activePlayer.getStyle());

						if (list.get(i).getPlayer() == null || list.get(i + ((ROWS + 1) * 1)).getPlayer() == null
								|| list.get(i + ((ROWS + 1) * 2)).getPlayer() == null) {

							activePlayer.setScore(activePlayer.getScore() + 1);

							list.get(i).setPlayer(activePlayer);
							list.get(i + ((ROWS + 1) * 1)).setPlayer(activePlayer);
							list.get(i + ((ROWS + 1) * 2)).setPlayer(activePlayer);

						}

					}

				}

				if (list.get(i).getVal().equals("S") && list.get(i + (ROWS - 1)).getVal().equals("O")
						&& list.get(i + (ROWS - 1) * 2).getVal().equals("S")) {

					if (i + (ROWS - 1) % 10 == 0) {
					} else {

						if (list.get(i).getPlayer() == null || list.get(i + ((ROWS + 1) * 1)).getPlayer() == null
								|| list.get(i + ((ROWS + 1) * 2)).getPlayer() == null) {

							activePlayer.setScore(activePlayer.getScore() + 1);

							list.get(i).setPlayer(activePlayer);
							list.get(i + ((ROWS - 1) * 1)).setPlayer(activePlayer);
							list.get(i + ((ROWS - 1) * 2)).setPlayer(activePlayer);

						}

						list.get(i).setStyle(activePlayer.getStyle());
						list.get(i + ((ROWS - 1) * 1)).setStyle(activePlayer.getStyle());
						list.get(i + ((ROWS - 1) * 2)).setStyle(activePlayer.getStyle());

					}
				}
			}

		}

		return list;
	}

	/**
	 * 
	 * @param playerBlock
	 * @return
	 */
	public PlayerBlock playerBlockService(PlayerBlock playerBlock) {

		activePlayer = playerBlock.getPlayer();

		List<Block> listTmp = new ArrayList<>(playerBlock.getBlockList());
		checkRows(listTmp);
		checkCols(listTmp);
		checkDiag(listTmp);

		playerBlock.setBlockList(listTmp);

		playerBlock.setPlayer(activePlayer);

		return playerBlock;
	}

	/**
	 * change turn
	 * 
	 * @return
	 */
	public int changeTurn() {

		if (this.turn == 1) {
			this.turn = 0;
		} else {
			this.turn = 1;
		}

		return this.turn;
	}

	/**
	 * init player list
	 * 
	 * @return
	 */
	public List<Player> playerList() {

		List<Player> list = new ArrayList<>();
		Player playerMozcan = new Player();
		playerMozcan.setName("MOZCAN");
		playerMozcan.setScore(0);
		playerMozcan.setOrder(true);
		playerMozcan.setStyle("win");

		Player playerSnn = new Player();
		playerSnn.setName("SNN");
		playerSnn.setScore(0);
		playerSnn.setStyle("win2");
		playerSnn.setOrder(false);

		list.add(playerMozcan);
		list.add(playerSnn);

		return list;

	}

}