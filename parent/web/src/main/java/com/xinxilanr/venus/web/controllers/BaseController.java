/**
 * 
 */
package com.xinxilanr.venus.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author norris
 *
 */
public class BaseController {
	public ModelAndView contextRedirect(String url, Model model) {
		return new ModelAndView(new RedirectView(url, true), model.asMap());
	}
}
