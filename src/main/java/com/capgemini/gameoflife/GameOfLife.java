package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	
	List<GameCell> allCells = new ArrayList<GameCell>();

	public List<GameCell> getAllCells() {
		return this.allCells;
	}
	
	public void addCell(GameCell singleCell){
		allCells.add(singleCell);
	}

	public void playRound() {
		for(GameCell singleCell : allCells){
			singleCell.predictCellStateInNextRound();
		}
		
		for(GameCell singleCell : allCells){
			singleCell.updateCellsState();
		}
	}


}
