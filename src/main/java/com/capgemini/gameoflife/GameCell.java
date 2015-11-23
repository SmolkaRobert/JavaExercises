package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameCell {
	private List<GameCell> neighbourCells = new ArrayList<GameCell>();

	private boolean cellIsAlive = true;
	private boolean cellWillLiveNextRound;

	boolean checkIfAlive() {
		return cellIsAlive;
	}

	void predictCellStateInNextRound() {
		int numberOfAliveNeighbours = 0;
		
		for(GameCell singleNeighbour : neighbourCells){
			if(singleNeighbour.checkIfAlive()){
				numberOfAliveNeighbours++;
			}
		}
		
		if(numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3){
			cellWillLiveNextRound = true;
		}
		else{
			cellWillLiveNextRound = false;
		}
	}

	void updateCellsState() {
		cellIsAlive = cellWillLiveNextRound;
	}

	void addNeighbours(List<GameCell> temporaryNeighbourCells) {
		neighbourCells.addAll(temporaryNeighbourCells);
	}


}
