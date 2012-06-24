package in.co.zybotech.web.controller.student;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.model.career.CareerStudent;
import in.co.zybotech.service.CareerManager;
import in.co.zybotech.web.utils.RequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private CareerManager careerManager;

	@RequestMapping("/students")
	public ModelAndView students(
			SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", careerManager.getStudentsForCareer());
		model.put("editable", requestUtils.isEditable(request, "student_admin"));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/students");
	}

	@RequestMapping("/student/{id}")
	public @ResponseBody
	Object student(HttpServletRequest request, @PathVariable int id) {
		CareerStudent student = careerManager
				.getObject(CareerStudent.class, id);
		if (student == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}
		return student;
	}

}
