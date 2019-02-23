package com.mycompany.heromarsspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/calc")
public class MarsController {

//	@Autowired
//	private HexaCalculatorService hexaCalculatorService;
//
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = "calculate/{num1}/{num2}") // template url - url 1 szegmense paraméterként működik:
//														// http://localhost:8095/calc/calculate/150/15
//	public String calculate(@PathVariable("num1") int a, @PathVariable("num2") int b) {
//
//		return hexaCalculatorService.add(a, b);
//
//	}
//
//	@RequestMapping(value = "calculate2") // ez a ? és & -es url-ben történő paraméterátadást támogatja:
//											// http://localhost:8095/calc/calculate2?a=150&b=15
//	public String calculate2(@RequestParam("a") int a, @RequestParam("b") int b) {
//
//		return hexaCalculatorService.add(a, b);
//
//	}
//
//	@RequestMapping("user")
//	public @ResponseBody User getUser() {
//
//		return new User(null, "Kiss", "Mariska");
//	}
//
//	@RequestMapping(value = "user2", method = RequestMethod.POST) // így csak POST hívásra reagál
//	public @ResponseBody User convertUser(@RequestBody User user) {
//
//		String firstName = user.getFirstName().toUpperCase();
//		String lastName = user.getLastName().toUpperCase();
//
//		return new User(null, firstName, lastName);
//	}
//
//	@RequestMapping(value = "findUser", method = RequestMethod.GET)
//	public List<User> findUserByFistName(@RequestParam("firstName") String firstName) {
//
//		return userService.findByFirstName(firstName);
//
//	}
//	
//	@RequestMapping(value = "createUser", method = RequestMethod.POST) // így csak POST hívásra reagál
//	public @ResponseBody User createUser(@RequestBody User user) {
//
//		return userService.createUser(user);
//
//	}
//	
//	@RequestMapping(value = "findAllUser", method = RequestMethod.GET)
//	public List<User> findAllUser() {
//
//		return userService.findAllByOrderByFirstNameAsc();
//
//	}

}
