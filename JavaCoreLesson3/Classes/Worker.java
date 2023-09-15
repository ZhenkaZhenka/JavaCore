package JavaCoreLesson3.Classes;

public class Worker extends Employee{
    private double income;
    Worker(){
        super.name = getString("Введите имя сотрудника: ");
        super.surname = getString("Введите фамилию сотрудника: ");
        setIncome(getDouble("Введите оклад работника: "));
    }
    Worker(String name, String surname, double income){
        super.name = name;
        super.surname = surname;
        this.income = income;
    }
    Worker(String name, String surname){
        super.name = name;
        super.surname = surname;
        setIncome(getDouble("Введите оклад работника: "));
    }
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    @Override
    double salary() {
        return getIncome();
    }

    @Override
    public String toString() {
        return surname + " " +
                name +
                ", salary = " + salary();
    }
    @Override
    public int compareTo(Employee o) {
        if(surname.equals(o.surname)){
            return name.compareTo(o.name);
        }
        else{
            return surname.compareTo(o.surname);
        }
    }
}
