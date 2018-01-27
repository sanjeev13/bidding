package com.xchain.bid.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.xchain.bid.model.User;
import com.xchain.bid.model.UserType;
import com.xchain.bid.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(Model model) {
		initUser(model);
		return new ModelAndView("add-user");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("user") User user, 
			BindingResult result,Model model) {
		
		userService.save(user);

		model.addAttribute("users", userService.getAllUsers());
		initUser(model);
		return new ModelAndView("add-user");
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView showAll(Model model) {

		model.addAttribute("users", userService.getAllUsers());
		return new ModelAndView("show-all-users");
	}

	@RequestMapping(value = "/{id}/bids", method = RequestMethod.GET)
	public ModelAndView showBidBoard(@PathVariable Long id,
			Model model) {

		model.addAttribute("bids",userService.getBids(id));
		return new ModelAndView("show-all-bids");
	}

	private void initUser(Model model) {
		List<String> typeList = new ArrayList<String>();
		for(UserType type: UserType.values()) {
			typeList.add(type.toString());
		}
		model.addAttribute("typeList",typeList);	
		model.addAttribute("user",new User());
	}
}
