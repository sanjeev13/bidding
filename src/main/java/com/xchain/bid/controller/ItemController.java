package com.xchain.bid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xchain.bid.model.form.DynamicItemsForm;

@Controller
public class ItemController {

	@RequestMapping(value="/createDetails")
	public String list(Model model){
		DynamicItemsForm dynamicRowForm = new DynamicItemsForm();
		model.addAttribute("DynamicItemsForm",dynamicRowForm);

		return "add-items";
	}

	@RequestMapping(value="/save")
    public String showList(@ModelAttribute DynamicItemsForm dynamicRowForm) {
      //  System.out.println(dynamicRowForm.getDynamicRow().get(0).getId());
        System.out.println(dynamicRowForm.getDynamicRow().get(0).getName());
        System.out.println(dynamicRowForm.getDynamicRow().get(0).getDescription());
        return "success";
    }
}