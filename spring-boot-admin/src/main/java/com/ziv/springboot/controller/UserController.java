package com.ziv.springboot.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ziv.springboot.bean.User;
import com.ziv.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user_manage")
	public ModelAndView user_manage(ModelAndView modelAndView){
//		List<User> users = new ArrayList<User>();
		modelAndView.setViewName("user/manager");
//		try{
//			users = userService.queryUsers();
//			modelAndView.addObject("users", users);
//		}catch(Exception e){
//			modelAndView.setViewName("404");
//			e.printStackTrace();
//		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public void users(HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		JSONObject resultJson = new JSONObject();
		List<User> users = new ArrayList<User>();
		PrintWriter pw = null;
		try{
			pw = response.getWriter();
			users = userService.queryUsers();
			resultJson.put("total", users.size());
			resultJson.put("rows", JSONArray.toJSON(users));
			pw.write(resultJson.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.flush();
				pw.close();
			}
		}
	}
	
	@RequestMapping("/searchUser")
	public ModelAndView searchUser(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("user/manager");
//		List<User> users = new ArrayList<User>();
//		try{
//			String username = request.getParameter("username");
//			if(!Strings.isNullOrEmpty(username)){
//				User user = userService.queryUserByName(username);
//				if (Objects.nonNull(user)) {
//					users.add(user);
//				}
//			}
//			request.setAttribute("users", users);
//		}catch(Exception e){
//			modelAndView.setViewName("404");
//			e.printStackTrace();
//		}
		return modelAndView;
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelAndView addUser_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("user/addUser");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser_post(HttpServletRequest request, HttpServletResponse response){
//		try{
//			User user = new User();
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String realname = request.getParameter("realname");
//			String email = request.getParameter("email");
//			String status = request.getParameter("status");
//			Integer roleID = Integer.parseInt(request.getParameter("roleID"));
//			user.setUsername(username);
//			user.setPassword(password);
//			user.setRealname(realname);
//			user.setEmail(email);
//			user.setStatus(status);
//			user.setRoleID(roleID);
//			userService.addUser(user);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return "redirect:/user_manage";
	}
	
	@RequestMapping(value="/editUser", method=RequestMethod.GET)
	public ModelAndView editUser_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("user/editUser");
		try{
			String id = request.getParameter("id");
			User user = userService.queryUserByID(id);
			modelAndView.addObject("user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value="/editUser", method=RequestMethod.POST)
	public String editUser_post(HttpServletRequest request, HttpServletResponse response){
//		try{
//			User user = new User();
//			Integer id = Integer.parseInt(request.getParameter("id"));
//			String username = request.getParameter("username");
//			String realname = request.getParameter("realname");
//			String email = request.getParameter("email");
//			String status = request.getParameter("status");
//			Integer roleID = Integer.parseInt(request.getParameter("roleID"));
//			user.setUserID(id);
//			user.setUsername(username);
//			user.setRealname(realname);
//			user.setEmail(email);
//			user.setStatus(status);
//			user.setRoleID(roleID);
//			userService.editUser(user);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return "redirect:/user_manage";
	}
	
	@RequestMapping(value="/resetUserPassword", method=RequestMethod.GET)
	public ModelAndView resetUserPassword_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("user/resetUserPassword");
		try{
			String id = request.getParameter("id");
			User user = userService.queryUserByID(id);
			modelAndView.addObject("user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value="/resetUserPassword", method=RequestMethod.POST)
	public String resetUserPassword_post(HttpServletRequest request, HttpServletResponse response){
//		try{
//			User user = new User();
//			Integer id = Integer.parseInt(request.getParameter("id"));
//			String password = request.getParameter("password");
//			user.setUserID(id);
//			user.setPassword(password);
//			userService.resetUserPassword(user);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return "redirect:/user_manage";
	}
	
}
