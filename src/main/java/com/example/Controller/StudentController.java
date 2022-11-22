package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@Controller
public class StudentController {

	@Autowired
	StudentDAO studentdao;

	@RequestMapping("index")
	public String student() {
		return "index.jsp";
	}

	@RequestMapping("addStudent")
	public String addstudent(Student Student) {
		studentdao.save(Student);
		return "index.jsp";
	}

	@RequestMapping("getStudent")
	public ModelAndView getStudent(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("showStudent.jsp");
		Student student = studentdao.findById(id).orElse(new Student());
		mav.addObject(student);
		return mav;

	}

	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("deleteStudent.jsp");
		Student student = studentdao.findById(id).orElse(new Student());
		studentdao.deleteById(id);
		mav.addObject(student);
		return mav;

	}
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		ModelAndView mav = new ModelAndView("updateStudent.jsp");
		student = studentdao.findById(student.getId()).orElse(new Student());
		studentdao.deleteById(student.getId());
		mav.addObject(student);
		return mav;

	}

}
