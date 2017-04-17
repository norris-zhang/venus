/**
 * 
 */
package com.xinxilanr.venus.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author norris
 *
 */
@Controller
public class PostController extends BaseController {
	@GetMapping("/posts")
	public String listPosts() {
		return "post/postlist";
	}
	@GetMapping("/publish")
	public ModelAndView publish() {
		return new ModelAndView("post/publish");
	}
}
