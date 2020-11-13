import java.util.*;
import java.io.Serializable;

public class TrainingAgency implements Serializable{

	private String name;
	private String location;

	private ArrayList<Trainer> trainerArray = 
	new ArrayList<Trainer>();
	private ArrayList<Course> courseArray = 
	new ArrayList<Course>();

	public TrainingAgency() {
		name = "Excellent IT Training Sdn Bhd";
		location = "KL";
	}
	public TrainingAgency(String name, String location) {
		this.name = name;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public ArrayList<Trainer> getTrainerArray() {
		return trainerArray;
	}
	public ArrayList<Course> getCourseArray() {
		return courseArray;
	}

	//sort
	public void trainerDefault() {
		Collections.sort(trainerArray, new TrainerDefaultComparator());
	}
	public void trainerByName() {
		Collections.sort(trainerArray, new TrainerNameComparator());
	}
	public void trainerByCourseTaught() {
		Collections.sort(trainerArray, new TrainerCTComparator());
	}

}