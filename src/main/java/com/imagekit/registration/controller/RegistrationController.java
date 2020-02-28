package com.imagekit.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.imagekit.registration.api.RegistrationApi;
import com.imagekit.registration.dto.User;
import com.imagekit.registration.service.UserService;

@Controller
public class RegistrationController implements RegistrationApi {

	@Autowired
	UserService userService;

	@Override
	public ModelAndView showRegistrationForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User userDto = new User();
		modelAndView.addObject(userDto);
		int IpCount = userService.getIpCount(request.getRemoteAddr());
		if (IpCount > 3) {
			modelAndView.setViewName("register_recaptcha.html");
		} else {
			modelAndView.setViewName("register.html");
		}
		return modelAndView;
	}

	@Override
	public ModelAndView registerUserAccount(@ModelAttribute("user") User userDto, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("errorMessage", "Errors in the input");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register.html");
		userService.saveUser(userDto, request.getRemoteAddr());
		return modelAndView;
	}
}
