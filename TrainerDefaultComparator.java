import java.util.*;

class TrainerDefaultComparator implements Comparator<Trainer> {

	//compare flight based on the flight type
	public int compare(Trainer t1, Trainer t2) {
		if (t1.getID() == t2.getID())
			return 0;
		else if (t1.getID() > t2.getID())
			return 1;
		else
			return -1;
	}
}