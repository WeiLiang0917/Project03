package gdcp.domain;

import  gdcp.service.Status;
import gdcp.domain.Employee;
import gdcp.domain.Equipment;

public class Programmer extends Employee {
	private int memberId;//员工号
	private Status status = Status.FREE;
	private Equipment equipment;
	
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id,name,age,salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


	@Override
	public String toString() {
		return getDetails()+"\t程序员\t"+status.toString()+"\t\t\t\t\t"+equipment.getDescription();

	}
	public String getDetial(){
		return memberId+"/"+getId()+"\t"+getName()+"\t"+"\t"+getSalary()+"\t程序员";
	}
}
