package gdcp.juint;

import gdcp.domain.Employee;
import gdcp.service.NameListService;
import gdcp.service.TeamException;
import org.junit.Test;

/**
 * @author WeiLiang
 * @date 2021/6/20 - 19:42
 */
public class NameListTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id=1;
        Employee employee = null;
        try {
            employee = service.getEmployee(101);
            System.out.println(employee);
        } catch (TeamException e) {
            e.printStackTrace();
        }

    }
}
