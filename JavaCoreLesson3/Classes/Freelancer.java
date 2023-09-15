package JavaCoreLesson3.Classes;

public class Freelancer extends Employee{
    private double wageRate;
    public double getWageRate() {
        return wageRate;
    }

    Freelancer(){
        super.name = getString("Введите имя сотрудника: ");
        super.surname = getString("Введите фамилию сотрудника: ");
        setWageRate(getDouble("Введите тарифную ставку работника: "));
    }
    Freelancer(String name, String surname, double income){
        super.name = name;
        super.surname = surname;
        this.wageRate = income;
    }
    Freelancer(String name, String surname){
        super.name = name;
        super.surname = surname;
        setWageRate(getDouble("Введите тарифную ставку работника: "));
    }

    public void setWageRate(double wageRate) {
        this.wageRate = wageRate;
    }

    @Override
    double salary() {
        return 20.8 * 8 * getWageRate();
    }

    @Override
    public String toString() {
        return surname + " " +
                name +
                ", salary = " + salary();
    }
}
