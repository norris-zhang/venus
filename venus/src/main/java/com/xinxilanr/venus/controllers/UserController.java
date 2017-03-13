/**
 * 
 */
package com.xinxilanr.venus.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinxilanr.venus.manager.UserManager;

/**
 * @author norris
 *
 */
@Controller
@EnableAutoConfiguration
public class UserController {
	private UserManager userManager;
	public UserController(UserManager userManager) {
		this.userManager = userManager;
	}
	@RequestMapping(value="/login", method=GET)
	@ResponseBody
	public String home(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		userManager.register(null);
		return "greeting";
	}
}
