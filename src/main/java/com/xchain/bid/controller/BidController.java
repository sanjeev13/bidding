package com.xchain.bid.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.xchain.bid.model.form.BidForm;
import com.xchain.bid.service.BidService;
import com.xchain.bid.service.CatalogService;
import com.xchain.bid.service.UserService;

@Controller
public class BidController {
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private UserService userService;
	@Autowired
	private BidService bidService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "/bid/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {

		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/bid", method = RequestMethod.GET)
	public ModelAndView showForm(Model model) {

		initBidForm(model);
		return new ModelAndView("add-bid");
	}

	private void initBidForm(Model model) {
		model.addAttribute("userList", userService.getUsersDisplayList());
		model.addAttribute("catalogList", catalogService.getCatalogsDisplayList());
		model.addAttribute("bid",new BidForm());
	}

	@RequestMapping(value = "/bid", method = RequestMethod.POST)
	public String submit(@ModelAttribute("bid") BidForm bidForm, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Error";
		}
		bidService.save(bidForm);
		initBidForm(model);
		model.addAttribute("bids", bidService.getAllBids());
		return "add-bid";
	}

	@RequestMapping(value = "/bids/all", method = RequestMethod.GET)
	public ModelAndView showAll(Model model) {
		
		model.addAttribute("bids", bidService.getAllBids());
		return new ModelAndView("show-all-bids");
	}

}
