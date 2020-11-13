import java.io.Serializable;

public class FullTime extends Trainer implements Serializable{
    
    private double rate;

    public FullTime(String name, double baseSalary, double rate) {
        super(name, baseSalary);
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
    public String getCategory() {
        return "Full Time";
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double commission() {
        double commission = 0;
        for (Course i : getCourseArray()) {
            if (i.getTrainerIdNumber() == getID())
                commission += 
            (i.getSeatBooked() * i.getCost()) * (getRate() /100);
        }
        return commission;
    }
    public void assign(Course course) {
        course.setTrainerIdNumber(getID());
    }
}
