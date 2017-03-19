/**
 * 
 */
package com.xinxilanr.venus.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinxilanr.venus.manager.UserManager;
import com.xinxilanr.venus.manager.dto.RegisterDto;
import com.xinxilanr.venus.service.HttpService;
import com.xinxilanr.venus.web.forms.RegisterForm;
import com.xinxilanr.venus.web.forms.validators.RegisterFormValidator;
import com.xinxilanr.venus.web.utils.HttpUtil;



/**
 * @author norris
 *
 */
@Controller
@EnableAutoConfiguration
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserManager userManager;
	private HttpService httpService;
	private RegisterFormValidator registerFormValidator;
	public UserController(UserManager userManager, HttpService httpService, RegisterFormValidator registerFormValidator) {
		this.userManager = userManager;
		this.httpService = httpService;
		this.registerFormValidator = registerFormValidator;
	}

	@RequestMapping(value="/", method=GET)
	@ResponseBody
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/register", method=GET)
	public String register(Model model) {
		model.addAttribute("form", new RegisterForm());
		return "user/register";
	}
	@RequestMapping(value="/register", method=POST)
	public String register(@Valid @ModelAttribute("form") RegisterForm form,
						   BindingResult result,
						   @RequestParam(name="g-recaptcha-response", required=false) String recaptchaResponse,
						   Model model,
						   HttpServletRequest request) {
		registerFormValidator.validate(form, result);
		if (result.hasErrors()) {
			return "user/register";
		}
		
		if (! httpService.verifyRecaptcha(recaptchaResponse)) {
			logger.warn("reCaptcha unsuccessful");
			return "user/register";
		}
		logger.info("ip is " + HttpUtil.getRemoteIp(request));
		userManager.register(new RegisterDto().setEmail(form.getEmail()).setPassword(form.getPassword()).setRemoteIp(HttpUtil.getRemoteIp(request)));
		return "user/register_success";
	}
}
