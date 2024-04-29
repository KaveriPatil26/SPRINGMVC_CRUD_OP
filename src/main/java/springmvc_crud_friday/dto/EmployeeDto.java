package springmvc_crud_friday.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDto{
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + "]";
	}
}