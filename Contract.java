import java.io.Serializable;

public class Contract extends Trainer implements Serializable{
    
    private double allowance;

    public Contract(String name, double baseSalary, double allowance) {
        super(name, baseSalary);
        this.allowance = allowance;
    }

    public double getAllowance() {
        return this.allowance;
    }
    public String getCategory() {
        return "Contract";
    }
    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    public double commission() {
       double commission = 0;
        for (Course i : getCourseArray()) {
            if (i.getTrainerIdNumber() == getID())
                commission += (i.getSeatBooked() * getAllowance());
        }
        return commission;
    }
    public void assign(Course course) {
        course.setTrainerIdNumber(getID());
    }


}
