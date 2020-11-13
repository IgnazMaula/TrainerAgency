import java.io.Serializable;

public class Course implements Serializable {

	private int courseID;
	private String name;
	private int level;
	private String code;
	private double cost;
	private int noOfDay;
	private int seatBooked;
	private int trainerIdNumber;

	private static int nextID = 0;

	public Course(String name, int level, double cost, int noOfDay, 
		int seatBooked, int trainerIdNumber) {
		courseID = ++nextID;
		this.name = name;
		this.level = level;
		this.cost = cost;
		this.noOfDay = noOfDay;
		this.seatBooked = seatBooked;
	}
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public String getCode() {
		String code;
		String levelSTR;
		if(level == 1)
			levelSTR = "1";
		else if(level ==2)
			levelSTR = "2";
		else
			levelSTR = "3";

		code = "SC" + levelSTR + String.format("%02d", courseID);

		return code;
	}
	public double getCost() {
		return cost;
	}
	public int getNoOfDay() {
		return noOfDay;
	}
	public int getSeatBooked() {
		return seatBooked;
	}
	public int getTrainerIdNumber() {
		return trainerIdNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setNoOfDay(int noOfDay) {
		this.noOfDay = noOfDay;
	}
	public void setSeatBooked(int seatBooked) {
		this.seatBooked = seatBooked;
	}
	public void setTrainerIdNumber(int trainerIdNumber) {
		this.trainerIdNumber = trainerIdNumber;
	}

}