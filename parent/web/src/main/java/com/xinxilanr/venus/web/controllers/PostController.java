/**
 * 
 */
package com.xinxilanr.venus.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author norris
 *
 */
@Controller
public class PostController {
	@GetMapping("/posts")
	public String listPosts() {
		return "post/postlist";
	}
}
