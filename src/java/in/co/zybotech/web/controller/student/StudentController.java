package in.co.zybotech.web.controller.student;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.web.model.ajax.Redirect;
import in.co.zybotech.model.career.Student;
import in.co.zybotech.service.StudentManager;
import in.co.zybotech.web.utils.RequestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private StudentManager studentManager;

	@RequestMapping("/students")
	public ModelAndView students(
			SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", studentManager.getStudents());
		model.put("dc", new Date().getTime());
		model.put("editable", requestUtils.isEditable(request, "student_admin"));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/students/list");
	}

	@RequestMapping(value = "/student/photo/{id}", method = RequestMethod.GET)
	public void photo(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Student student = studentManager.getObject(Student.class, id);
		if (student == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}

		byte[] bytes = studentManager.getBytes(Student.class, id, "image");
		if (bytes != null) {
			RequestUtils.sendStream(response, student.getImageName(),
					new ByteArrayInputStream(bytes), bytes.length);
		}

	}

	@RequestMapping("/student/{id}")
	public @ResponseBody
	Object student(HttpServletRequest request, @PathVariable int id) {
		Student student = studentManager.getObject(Student.class, id);
		if (student == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}
		return student;
	}

	@RequestMapping(value = "/admin/student/edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_STUDENT_ADMIN")
	public ModelAndView edit(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", studentManager.getObject(Student.class, id));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/students/edit");
	}

	@RequestMapping(value = "/admin/student/edit/{id}", method = RequestMethod.POST)
	@Secured("ROLE_STUDENT_ADMIN")
	public @ResponseBody
	Redirect editpost(SecurityContextHolderAwareRequestWrapper request,
			@Valid @ModelAttribute StudentForm form, @PathVariable int id)
			throws IOException {
		Student student = studentManager.getObject(Student.class, id);
		if (student == null) {
			student = new Student();
		}
		form.set(student);
		studentManager.saveObject(student, Student.class);
		return new Redirect("/students");
	}

	@RequestMapping(value = "/admin/student/delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_STUDENT_ADMIN")
	public @ResponseBody
	Student delete(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		Student student = studentManager.remove(Student.class, id);
		return student;
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
}
