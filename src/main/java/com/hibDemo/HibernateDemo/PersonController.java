package com.hibDemo.HibernateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hibDemo.HibernateDemo.dao.PersonDao;
import com.hibDemo.HibernateDemo.entity.Person;

@Controller
public class PersonController {
	@Autowired
	PersonDao p;
	
	@RequestMapping("/")
	public String index(Model model) {
		// can add EL tags using the model and model.addAttribute();
		// this is an alternative to the ModelAndView addObject();
		model.addAttribute("list", p.findAll());
		System.out.println(p.findAll());
		return "index";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("personid") int id) {
		Person p1 = p.findById(id);
		System.out.println(p1);
		
		return new ModelAndView("search","person", p1);
	}
	
//	@RequestMapping(value="/add", method= RequestMethod.POST)
	@PostMapping("/add")
	public ModelAndView add(@RequestParam("name") String n, @RequestParam("location") String loc) {
			
		Person p1 = new Person(n, loc);
		p.update(p1);
		return new ModelAndView("index", "list", p.findAll());
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam("id") int pID) {
		p.deleteById(pID);
		return new ModelAndView("index", "list", p.findAll());
	}
	
	@RequestMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam("id") int id) {
		return new ModelAndView("updateform","id",id);
	}
	
	
	@PostMapping("/updateperson")
	public ModelAndView change(@RequestParam(value="id") int idNum, @RequestParam(value="name") String n, @RequestParam(value="location") String loc) {
		System.out.println(idNum);
		System.out.println(n);
		
		//Alternative
		// Person p1 = new Person(id, pName, location);
		//p.update(p1);
		Person p1 = p.findById(idNum);
		p1.setLocation(loc);
		p1.setName(n);
		p.update(p1);
		return new ModelAndView("index", "list", p.findAll());
	}
}
