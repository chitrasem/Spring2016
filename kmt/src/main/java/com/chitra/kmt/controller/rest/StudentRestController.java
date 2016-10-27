package com.chitra.kmt.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chitra.kmt.model.Student;
import com.chitra.kmt.model.User;
import com.chitra.kmt.service.StudentService;
import com.chitra.kmt.service.UserService;
import com.chitra.kmt.utils.SSOIdUtil;

@RestController
@RequestMapping("/dashboard")
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	
	
	SSOIdUtil sSOIdUtil;
	
	
	@RequestMapping(value = "/student", method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllStudnet(@RequestParam("lang") String language,
											@RequestParam("searchName") String searchName,
											@RequestParam("numberOfRecord") int numberOfRecord,
											@RequestParam("pageCount") int pageCount){
		int offset = (pageCount-1)*numberOfRecord;
		
		String firstName = "";
		String lastName = "";
		if(language.equalsIgnoreCase("km")){
			firstName = "student.kmFirstName";
			lastName = "student.kmLastName";
		}else{
			firstName = "student.firstName";
			lastName = "student.lastName";
		}
		
		sSOIdUtil = new SSOIdUtil();		
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Student> students =  (List<Student>)(studentService.findAll(user.getId(), firstName, lastName, searchName, numberOfRecord, offset));
		
		
		
		long recordTotal = studentService.countRecordListl(user.getId(), firstName, lastName, searchName);
		
		if(students == null){
             map.put("List", null);     
		}else{
			map.put("RecordTotal", recordTotal);
			map.put("List", students);
			
		}   
		return map;
		
	}
	
	@RequestMapping(value="/student/export", method = RequestMethod.GET)
	public ModelAndView exportStudents(SSOIdUtil ssoIdUtil, User user){
		user = userService.findBySso(ssoIdUtil.getPrincipal());
		
		String firstName = "student.kmFirstName";
		String lastName = "student.kmLastName";
		String searchName = "%";
		int maxResult = 10;
		int firstResult = 1;
		
		List<Student> students = (List<Student>) studentService.findAll(user.getId(), firstName, lastName, searchName, maxResult, firstResult);

		System.out.println(students);
		
		return new ModelAndView("excelViewStudents", "students",students);
		
		//return new ModelAndView();
	}
	/**
	 * Retrive single student********************************************************************************************************
	 * @param id
	 * @return
	 */
	   @RequestMapping(value = "/student/{stu_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Map<String, Object> getStudent(@PathVariable("stu_id") int id) {
	        System.out.println("Fetching Student with id " + id);
	        Student student = studentService.findById(id);
	        Map<String, Object> map = new HashMap<String, Object>();
	        if (student == null) {
	            map.put("List", "NOT FOUND");
	            
	        }else{
	        	map.put("List", student);
	        	
	        }
	        return map;
	    
	}

}
