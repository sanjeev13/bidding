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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.xchain.bid.model.form.CatalogForm;
import com.xchain.bid.service.CatalogService;
import com.xchain.bid.service.UserService;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;
	@Autowired
	private UserService userService;
		
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(Model model) {
		intiCatalogForm(model);
		return new ModelAndView("add-catalog");
	}

	private void intiCatalogForm(Model model) {
		model.addAttribute("catalogForm", new CatalogForm());
		model.addAttribute("userList", userService.getUsersDisplayList());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("catalogForm") CatalogForm catalogForm, 
			BindingResult result, Model model) {

		CatalogForm form = new CatalogForm();
		ModelAndView mav = new ModelAndView("add-catalog");
		catalogService.save(catalogForm);
		model.addAttribute("userList", userService.getUsersDisplayList());
		mav.addObject("catalogs", form);
		return mav;

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView showAll(Model model) {
		
		model.addAttribute("catalogs", catalogService.getAllCatalogs());
		return new ModelAndView("show-all-catalog");
	}
	
	@RequestMapping(value = "/{id}/bids", method = RequestMethod.GET)
	public ModelAndView showBidBoard(@PathVariable Long id,
			Model model) {

		model.addAttribute("bids",catalogService.getBids(id));
		return new ModelAndView("show-all-bids");
	}

}