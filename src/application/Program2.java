package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department dep = departmentDao.findById(6);
		
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
			
		System.out.println("\n==== TEST 3: department insert ====");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Insert! new Id: " + newDep.getId());
		
		System.out.println("\n==== TEST 4: department update ====");
		
		dep = departmentDao.findById(3);
		dep.setName("Marketing");
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 5: department deleteById ====");
		
		System.out.print("Enter Id for delete test: ");
		
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
