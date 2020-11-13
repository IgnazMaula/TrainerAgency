import java.util.*;

class TrainerCTComparator implements Comparator<Trainer> {

	//compare flight based on the flight type
	public int compare(Trainer t1, Trainer t2) {
		if (t1.getCourseTaught() == t2.getCourseTaught())
			return 0;
		else if (t1.getCourseTaught() > t2.getCourseTaught())
			return 1;
		else
			return -1;
	}
}