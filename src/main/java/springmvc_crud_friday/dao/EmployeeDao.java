package springmvc_crud_friday.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc_crud_friday.dto.EmployeeDto;

@Component
public class EmployeeDao {
	EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Kaveri");
	EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	EntityTransaction entitytransaction = entitymanager.getTransaction();

	public void insert(EmployeeDto employeeDto) {

		entitytransaction.begin();
		entitymanager.persist(employeeDto);
		entitytransaction.commit();
	}

	public EmployeeDto fetchById(int id) {
		EmployeeDto employeeDto = entitymanager.find(EmployeeDto.class, id);
		if (employeeDto != null) {
			return employeeDto;
		} else {
			return null;
		}

	}

	public String deleteById(int id) {
		EmployeeDto employeeDto = entitymanager.find(EmployeeDto.class, id);
		if (employeeDto != null) {
			entitytransaction.begin();
			entitymanager.remove(employeeDto);
			entitytransaction.commit();
			return "Data Deleted Successfully";
		} else {
			return "Data not found";
		}

	}

	public List<EmployeeDto> fetchAll() {
		Query query = entitymanager.createQuery("select a from EmployeeDto a");
		List<EmployeeDto> obj = query.getResultList();
		if (obj.isEmpty()) {
			return null;
		} else
			return obj;

	}

	public String deleteAll() {
		Query query = entitymanager.createQuery("select a from EmployeeDto a");
		List<EmployeeDto> obj = query.getResultList();
		if (obj.isEmpty()) {
			return "Data not found";
		} else
			for (EmployeeDto a : obj) {
				entitytransaction.begin();
				entitymanager.remove(a);
				entitytransaction.commit();
			}
		return "Data Deleted Successfully";
	}

}