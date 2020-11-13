import java.util.*;

class TrainerNameComparator implements Comparator<Trainer> {

	//compare trainer based on the name
	public int compare(Trainer t1 , Trainer t2) {
		return t1.getName().compareTo(t2.getName());
	}
}