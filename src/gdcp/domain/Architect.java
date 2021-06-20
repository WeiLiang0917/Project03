package gdcp.domain;

public class Architect extends  gdcp.domain.Designer {
	private int stock;//股票

	public Architect(int id, String name, int age, double salary,
					 gdcp.domain.Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
	return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();

	}
	public String  getDetial(){
		return getMemberId()+"/"+getId()+"\t"+getName()+"\t"+"\t"+getSalary()+"\t架构师\t"+getStock();

	}
}
