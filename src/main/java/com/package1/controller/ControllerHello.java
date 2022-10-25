package com.package1.controller;

import java.util.List;

import com.package1.entity.Owner;
import com.package1.services.PetClinicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerHello {

	@Autowired
	private PetClinicService petClinicService;


	@RequestMapping("/owners1")
	public ModelAndView getOwners(){
		ModelAndView mav=new ModelAndView();
		List<Owner> owners = petClinicService.findAll();
		mav.addObject("owners",owners);
		mav.setViewName("owners");

//veritabanı bağ oluştur
//transaction başlatılır
//statement yarat
		//st üzerinden sql sorgusu çalıştır
		//stmt sonucu dönen bir resultSet varsa bu bir döngü ile işlenir

		return mav;
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello";
	}


	@RequestMapping("/HelloWorld")
	public ModelAndView firstPage() {
		return new ModelAndView("helloworld");
	}


}
