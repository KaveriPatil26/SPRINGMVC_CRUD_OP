package springmvc_crud_thursday.Controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc_crud_friday.dao.EmployeeDao;
import springmvc_crud_friday.dto.EmployeeDto;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		employeeDao.insert(employeeDto);
		return "data inserted successfully";
	}

	@RequestMapping("/fetchbyid")
	public ModelAndView fetchById(@RequestParam int id) {
		System.out.println(id);
		EmployeeDto employeeDto = employeeDao.fetchById(id);
		System.out.println(employeeDto);

		ModelAndView mv = new ModelAndView("fetchbyid.jsp");
		mv.addObject("object", employeeDto);
		return mv;
	}

	@RequestMapping("/deleteById/{pk}")
	@ResponseBody
	public String delete(@PathVariable int pk) {
		System.out.println(pk);
		return employeeDao.deleteById(pk);
	}

	@RequestMapping("/fetchall")
	public ModelAndView fetchAll() {
		List<EmployeeDto> obj = employeeDao.fetchAll();
		ModelAndView mv = new ModelAndView("fetchall.jsp");
		mv.addObject("data", obj);
		return mv;

	}

	@RequestMapping("/deleteall")
	@ResponseBody
	public String deleteAll() {
		String del=employeeDao.deleteAll();
		return del;
	}
}