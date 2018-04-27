package com.ziv.springboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ziv.springboot.bean.Menu;
import com.ziv.springboot.bean.Role;
import com.ziv.springboot.bean.User;
import com.ziv.springboot.service.MenuService;
import com.ziv.springboot.service.UserService;
import com.ziv.springboot.tools.Const;
import com.ziv.springboot.tools.RightsHelper;
import com.ziv.springboot.tools.Tools;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/")
	public String login_index(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(Objects.isNull(session.getAttribute(Const.SESSION_USER))){
			return "login";
		}else{
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/code",method=RequestMethod.GET)
	public void code(HttpServletRequest request, HttpServletResponse response){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String code = Tools.drawImg(output);
		HttpSession session = request.getSession();
		session.setAttribute(Const.SESSION_SECURITY_CODE, code); //放入session
		//System.out.println(session.getAttribute(Const.SESSION_SECURITY_CODE));
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login_get(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(Objects.isNull(session.getAttribute(Const.SESSION_USER))){
			return "login";
		}else{
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login_post(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		String errInfo = "";
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(Const.SESSION_SECURITY_CODE);
		String code = request.getParameter("code");
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		if(!StringUtils.isEmpty(sessionCode)&&sessionCode.equalsIgnoreCase(code)){
			User user = userService.queryUserByNameAndPwd(loginname,password);
			if(Objects.nonNull(user)){
				user.setLastLogin(new Date());
				userService.updateLastLogin(user);
				session.setAttribute(Const.SESSION_USER, user);
				session.removeAttribute(Const.SESSION_SECURITY_CODE);
			}else{
				errInfo = "用户名或密码有误！";
			}
		}else{
			errInfo = "输入验证码有误！";
		}
		if(StringUtils.isEmpty(errInfo)){
			modelAndView.setViewName("redirect:/index");
		}else{
			modelAndView.addObject("errInfo", errInfo);
			modelAndView.addObject("loginname",loginname);
			modelAndView.addObject("password",password);
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index_get(HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		user = userService.getUserAndRoleById(user.getUserId());
		Role role = user.getRole();
		String roleRights = Objects.nonNull(role.getRights())?role.getRights():"";
		String userRights = user.getRights();
		
		List<Menu> menus = menuService.queryAllMenu();
		if(!StringUtils.isEmpty(userRights)||!StringUtils.isEmpty(roleRights)){
			for(Menu menu:menus){
				menu.setHasMenu(RightsHelper.testRights(userRights, menu.getMenuId()) || RightsHelper.testRights(roleRights, menu.getMenuId()));
				if(menu.isHasMenu()){
					List<Menu> subMenus = menu.getSubMenu();
					for(Menu subMenu:subMenus){
						menu.setHasMenu(RightsHelper.testRights(userRights, subMenu.getMenuId()) || RightsHelper.testRights(roleRights, subMenu .getMenuId()));
					}
				}
			}
		}
		
		JSONArray menuNodes = new JSONArray();
		JSONObject nodeObj1 = new JSONObject();
		nodeObj1.put("id", "0");
		JSONArray nodeArr1 = new JSONArray();
		for(Menu m:menus){
			if(m.isHasMenu()){
				JSONObject nodeObj2 = new JSONObject();
				nodeObj2.put("text", m.getMenuName());
				JSONArray nodeArr2 = new JSONArray();
				for(Menu mm:m.getSubMenu()){
					JSONObject nodeObj3 = new JSONObject();
					nodeObj3.put("id", String.valueOf(mm.getMenuId()));
					nodeObj3.put("text", mm.getMenuName());
					nodeObj3.put("href", request.getContextPath()+mm.getMenuUrl());
					nodeArr2.add(nodeObj3);
				}
				nodeObj2.put("items", nodeArr2);
				nodeArr1.add(nodeObj2);
			}
		}
		
		nodeObj1.put("homePage", nodeArr1.getJSONObject(0).getJSONArray("items").getJSONObject(0).get("id"));
		nodeObj1.put("menu", nodeArr1);
		menuNodes.add(nodeObj1);
		
		modelAndView.setViewName("index");
		modelAndView.addObject("menuNodes", menuNodes);
		return modelAndView;
		
//			List<MenuNode> nodes = menuNodeService.queryNodesByRoleID(currentUser.getRoleID());
////			List<MenuNode> nodes = menuNodeService.queryNodes();
//			request.setAttribute("nodes", nodes);
//			JSONArray menuNodes = new JSONArray();
//			for(MenuNode n1:nodes){
//				if(n1.getParentNodeID()==0){
//					JSONObject nodeObj1 = new JSONObject();
//					nodeObj1.put("id", String.valueOf(n1.getNodeID()));
//					JSONArray nodeArr1 = new JSONArray();
//					for(MenuNode n2:nodes){
//						if(n2.getParentNodeID()==n1.getNodeID()){
//							JSONObject nodeObj2 = new JSONObject();
//							nodeObj2.put("text", n2.getNodeName());
//							JSONArray nodeArr2 = new JSONArray();
//							for(MenuNode n3:nodes){
//								if(n3.getParentNodeID()==n2.getNodeID()){
//									JSONObject nodeObj3 = new JSONObject();
//									nodeObj3.put("id", String.valueOf(n3.getNodeID()));
//									nodeObj3.put("text", n3.getNodeName());
//									nodeObj3.put("href", request.getContextPath()+n3.getNodeAction());
//									nodeArr2.add(nodeObj3);
//								}
//							}
//							nodeObj2.put("items", nodeArr2);
//							nodeArr1.add(nodeObj2);
//						}
//					}
//					nodeObj1.put("homePage", nodeArr1.getJSONObject(0).getJSONArray("items").getJSONObject(0).get("id"));
//					nodeObj1.put("menu", nodeArr1);
//					menuNodes.add(nodeObj1);
//				}
//			
//			request.setAttribute("menuNodes", menuNodes);
//			return "index";
//		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public void logout_get(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute(Const.SESSION_USER);
		try {
			response.sendRedirect(request.getContextPath()+"/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
