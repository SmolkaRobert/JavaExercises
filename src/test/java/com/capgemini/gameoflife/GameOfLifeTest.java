package com.capgemini.gameoflife;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void shouldReturnFalseForOneCell(){
		//given
		GameOfLife singleGame = new GameOfLife();
		singleGame.addCell(new GameCell());
		//when
		singleGame.playRound();
		GameCell cellToCheck = singleGame.getAllCells().get(0);
		//then
		assertThat(cellToCheck.checkIfAlive()).isEqualTo(false);
	}

	@Test
	public void shouldReturnFalseForTwoNeighbouringCells(){
		int maxNumberOfCells = 2;
		GameOfLife singleGame = new GameOfLife();
		//given
		for(int i=0; i<maxNumberOfCells ; i++){
			singleGame.addCell(new GameCell());
		}
		List<GameCell> allGameCells = singleGame.getAllCells();
		List<GameCell> temporaryNeighbourCells = new ArrayList<GameCell>(allGameCells);
		for(GameCell singleCell : allGameCells){
			temporaryNeighbourCells.remove(singleCell);
			singleCell.addNeighbours(temporaryNeighbourCells);
			temporaryNeighbourCells.add(singleCell);
		}
		//when
		singleGame.playRound();
		//then
		for(GameCell singleCell : singleGame.getAllCells()){
			assertThat(singleCell.checkIfAlive()).isEqualTo(false);
		}
	}

	@Test
	public void shouldReturnFalseForFiveNeighbouringCells(){
		int maxNumberOfCells = 5;
		GameOfLife singleGame = new GameOfLife();
		//given
		for(int i=0; i<maxNumberOfCells ; i++){
			singleGame.addCell(new GameCell());
		}
		List<GameCell> allGameCells = singleGame.getAllCells();
		List<GameCell> temporaryNeighbourCells = new ArrayList<GameCell>(allGameCells);
		for(GameCell singleCell : allGameCells){
			temporaryNeighbourCells.remove(singleCell);
			singleCell.addNeighbours(temporaryNeighbourCells);
			temporaryNeighbourCells.add(singleCell);
		}
		//when
		singleGame.playRound();
		//then
		for(GameCell singleCell : singleGame.getAllCells()){
			assertThat(singleCell.checkIfAlive()).isEqualTo(false);
		}
	}

	@Test
	public void shouldReturnFalseForEightNeighbouringCells(){
		int maxNumberOfCells = 8;
		GameOfLife singleGame = new GameOfLife();
		//given
		for(int i=0; i<maxNumberOfCells ; i++){
			singleGame.addCell(new GameCell());
		}
		List<GameCell> allGameCells = singleGame.getAllCells();
		List<GameCell> temporaryNeighbourCells = new ArrayList<GameCell>(allGameCells);
		for(GameCell singleCell : allGameCells){
			temporaryNeighbourCells.remove(singleCell);
			singleCell.addNeighbours(temporaryNeighbourCells);
			temporaryNeighbourCells.add(singleCell);
		}
		//when
		singleGame.playRound();
		//then
		for(GameCell singleCell : singleGame.getAllCells()){
			assertThat(singleCell.checkIfAlive()).isEqualTo(false);
		}
	}

	@Test
	public void shouldReturnTrueForThreeNeighbouringCells(){
		int maxNumberOfCells = 3;
		GameOfLife singleGame = new GameOfLife();
		//given
		for(int i=0; i<maxNumberOfCells ; i++){
			singleGame.addCell(new GameCell());
		}
		List<GameCell> allGameCells = singleGame.getAllCells();
		List<GameCell> temporaryNeighbourCells = new ArrayList<GameCell>(allGameCells);
		for(GameCell singleCell : allGameCells){
			temporaryNeighbourCells.remove(singleCell);
			singleCell.addNeighbours(temporaryNeighbourCells);
			temporaryNeighbourCells.add(singleCell);
		}
		//when
		singleGame.playRound();
		//then
		for(GameCell singleCell : singleGame.getAllCells()){
			assertThat(singleCell.checkIfAlive()).isEqualTo(true);
		}
	}

}
