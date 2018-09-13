package food;
import database.*;

public class Food {
	private String name;
	private double energy;
	private double protein;
	private double fat;
	private double sfa;
	private double carb;
	private double sugar;
	private double sodium;
	private double cost;
	
	public Food(String name, double energy, double protein, double fat, double sfa, double carb, double sugar,
			double sodium, double cost) {
		super();
		this.name = name;
		this.energy = energy;
		this.protein = protein;
		this.fat = fat;
		this.sfa = sfa;
		this.carb = carb;
		this.sugar = sugar;
		this.sodium = sodium;
		this.cost = cost;
	}

	public void insertFood() {
		SQLiteInsertFood.insertFood(this);
	}
	
	public void deleteFood() {
		SQLiteFoodSelect.deleteFoodByName(this.getName());
	}
	
	//Getters and Setters below
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSfa() {
		return sfa;
	}

	public void setSfa(double sfa) {
		this.sfa = sfa;
	}

	public double getCarb() {
		return carb;
	}

	public void setCarb(double carb) {
		this.carb = carb;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", energy=" + energy + ", protein=" + protein + ", fat=" + fat + ", sfa=" + sfa
				+ ", carb=" + carb + ", sugar=" + sugar + ", sodium=" + sodium + ", cost=" + cost + "]";
	}
	
	
}