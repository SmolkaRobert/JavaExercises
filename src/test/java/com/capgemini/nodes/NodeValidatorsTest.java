package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NodeValidatorsTest {

	@Test
	public void shouldNotThrowAnyExceptions(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("0002", "Second node description", "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		nodes.add(new Node("0004", "Fourth node description", "0003"));
		nodes.add(new Node("0005", "Fifth node description", "0003"));
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		//then
	}
	
	@Rule
	public ExpectedException thrownException = ExpectedException.none();
	
	@Test
	public void shouldThrowExceptionWhenIdIsLessThan4CharactersLong(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("02", "Second node description", "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Id 02 has to be 4 characters long.");
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
	
	@Test
	public void shouldThrowExceptionWhenIdIsMoreThan4CharactersLong(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("0002", "Second node description", "0001"));
		nodes.add(new Node("00003", "Third node description", "0002"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Id 00003 has to be 4 characters long.");
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
	
	@Test
	public void shouldThrowExceptionWhenDescriptionIsMoreThan128CharactersLong(){
		//given
		String stringOver128Characters = new String(new char[129]);
		
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("0002", stringOver128Characters, "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Node 0002 description can have 128 characters maximum : " + stringOver128Characters);
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
	
	@Test
	public void shouldThrowExceptionWhenFirstNodeHasCycles(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description", "0003"));
		nodes.add(new Node("0002", "Second node description", "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Cycles not allowed. Node: 0001 is a succesor of node: 0003");
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
	
	@Test
	public void shouldThrowExceptionWhenFourthNodeHasCycles(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("0002", "Second node description", "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		nodes.add(new Node("0004", "Fourth node description", "0004"));
		nodes.add(new Node("0005", "Fifth node description", "0003"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Cycles not allowed. Node: 0004 is a succesor of node: 0004");
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
	
	@Test
	public void shouldThrowExceptionWhenSecondNodeHasTwoSubsequentNodes(){
		//given
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0001", "First node description"));
		nodes.add(new Node("0002", "Second node description", "0001"));
		nodes.add(new Node("0003", "Third node description", "0002"));
		nodes.add(new Node("0004", "Fourth node description", "0002"));
		nodes.add(new Node("0005", "Fifth node description", "0003"));
		
		thrownException.expect(IllegalArgumentException.class);
		thrownException.expectMessage("Node: 0002 can have only one succesor.");
		
		//when
		NodeValidators validator = new NodeValidators();		
		validator.validateMethod(nodes);
		
		//then
	}
}
