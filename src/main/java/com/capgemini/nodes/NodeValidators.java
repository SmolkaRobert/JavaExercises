package com.capgemini.nodes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 *     <li>node id should have 4 characters</li>
 *     <li>node description can have maximal 128 characters</li>
 *     <li>no cycle</li>
 *     <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {
	private static final int MAX_DESCRIPTION_LENGTH = 128;
	private static final int ID_LENGTH = 4;

	public void validateMethod(List<Node> nodes) {
		List<String> predecessorIdList = new LinkedList<String>();

		for(int singleNode = 0; singleNode < nodes.size(); singleNode++){
			String id = nodes.get(singleNode).getId();
			String description = nodes.get(singleNode).getDescription();
			String predecessorId = nodes.get(singleNode).getPredecessorId();

			checkCorrectIdLength(id);

			checkCorrectDescriptionLength(id, description);

			checkForNoCycles(id, predecessorId, singleNode);

			if(singleNode < nodes.size() - 1){
				checkCorrectNumberOfPredecessors(predecessorId, predecessorIdList);
			}
			
			predecessorIdList.add(predecessorId);
		}
	}

	private void checkCorrectIdLength(String id) {
		if(id.length() != ID_LENGTH){
			throw new IllegalArgumentException("Id " + id + " has to be 4 characters long.");
		}
	}

	private void checkCorrectDescriptionLength(String id, String description) {
		if(description.length() > MAX_DESCRIPTION_LENGTH){
			throw new IllegalArgumentException("Node " +  id + " description can have 128 characters maximum : " + description);
		}
	}

	private void checkForNoCycles(String id, String predecessorId, int nodeNumber) {
		boolean nodePointsAtItself = (id.equals(predecessorId));
		boolean firstNodeHasPredecesor = (nodeNumber == 0 && !predecessorId.isEmpty());

		if(nodePointsAtItself || firstNodeHasPredecesor){
			throw new IllegalArgumentException("Cycles not allowed. Node: " + id + " is a succesor of node: " + predecessorId);
		}
	}
	
	private void checkCorrectNumberOfPredecessors(String predecessorId, List<String> predecessorIdList) {
		if(predecessorIdList.contains(predecessorId)){
			throw new IllegalArgumentException("Node: " + predecessorId + " can have only one succesor.");
		}
	}
	
}

