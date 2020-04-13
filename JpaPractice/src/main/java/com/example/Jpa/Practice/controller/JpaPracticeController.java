package com.example.Jpa.Practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Jpa.Practice.entity.User;
import com.example.Jpa.Practice.service.JpaPracticeService;

@Controller
public class JpaPracticeController {
	@Autowired
	private JpaPracticeService  jpaPracticeService;
	
	@RequestMapping("user_list")
	public String getUserList(Model model, String userId) {
		List<User> userList = jpaPracticeService.findUserByUserId(userId);
		model.addAttribute("OrdersDetails",userList);
		return "user_list";
	}
//	
//	@RequestMapping("/")
//	public String index() {return "redirect:OrdersDetail/list";}
//	
//	@RequestMapping("OrdersDetail/list")
//	public String findOrdersDetailInfo(Model model , @RequestParam(value = "userId" , defaultValue = "1") Integer userId){
//		List<OrderDetail> findDetails = jpaPracticeService.findDetails(userId);
//		model.addAttribute("OrdersDetails",findDetails);
//		return "OrdersDetail/list";
//	}
//	
//	@RequestMapping("toEdit")
//	public String editOrdersDetailInfo(Model model , @RequestParam(value = "userId" , defaultValue = "1") Integer userId){
//		System.out.println(userId);
//		return "OrdersDetail/list";
//	}
//	
//	@RequestMapping("toAdd")
//	public  String AddOrdersDetailInfo() {
//		return "OrdersDetail/AddOrderList";
//	}
//	
//	@RequestMapping("Add")
//	public  String Add( AddOrderDetailRequestDto addOrderDetailRequestDto ,BindingResult result , ModelMap model) {
//		String errorMsg="";
//		if(result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for(ObjectError error : list) {
//				errorMsg = errorMsg + error.getCode()+":" + error.getDefaultMessage();
//			}
//			model.addAttribute("errorMsg", errorMsg);
//		}
//		return "OrdersDetail/AddOrderList";
//	}
} 
