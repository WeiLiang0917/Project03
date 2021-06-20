package gdcp.service;
import static gdcp.service.Data.*;

import gdcp.domain.*;

/**
 * @author WeiLiang
 * @date 2021/6/20 - 19:07
 */
public class NameListService {
    private Employee[] employees;
//给数组即数组元素初始化
    public NameListService() {
        //1根据项目提供的Data类建立相应大小的employees数组
        //2再根据Data类中的数据构建不同的对象，包括Employee，Programmer，Dissi和Archi
        //3将对象存于数组中
        employees=new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的四个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age= Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment=createEquippment(i);
                    employees[i]=new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment=createEquippment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment=createEquippment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    stock=Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }

    }
//获取指定id的员工设备
    private Equipment createEquippment(int index) {
        int key = Integer.parseInt(EQIPMENTS[index][0]);
        String modelorname = EQIPMENTS[index][1];
        String display = EQIPMENTS[index][2];
        switch (key){
            case PC://21
                return new PC(modelorname,display);
            case NOTEBOOK://22
                double price= Double.parseDouble(EQIPMENTS[index][2]);
                return new NoteBook(modelorname,price);
            case PRINTER://23
                String type=EQIPMENTS[index][2];
                return new Printer(modelorname,type);
        }
        return null;
    }
//获取当前所有员工
    public Employee[] getAllEmployees() {
        return employees;
    }
    //获取指定id的员工
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId()==id){//本来得equ
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
    public void setEmployee(Employee[] employees) {
        this.employees = employees;
    }
}
