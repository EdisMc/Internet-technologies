package repositories;

import java.util.ArrayList;
import models.Participant;

public class ParticipantRepository {
	private ArrayList<Participant> participants = new ArrayList<Participant>();
	private static ParticipantRepository instance = null;
	
	public static ParticipantRepository getInstance() {
		if (instance == null) {
			instance = new ParticipantRepository();
		}
		return instance;
	}
	
	public void addParticipant(Participant participant) {
		participants.add(participant);
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

}
