package com.ziv.springboot.controller;

import org.springframework.stereotype.Controller;

@Controller
public class RoleController {/*

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuNodeService;
	
	@RequestMapping("/role_manage")
	public ModelAndView role_manage(ModelAndView modelAndView){
		modelAndView.setViewName("role/manager");
//		List<Role> roles = new ArrayList<Role>();
//		try{
//			roles = roleService.queryRoles();
//			if(Objects.nonNull(roles)){
//				for(Role role:roles){
//					List<Menu> menuNodes = menuNodeService.queryNodesByRoleID(role.getRoleID());
//					StringBuffer menuSb = new StringBuffer();
//					for(MenuNode mn:menuNodes){
//						menuSb.append(mn.getNodeName());
//						menuSb.append(",");
//					}
//					role.setRoleMenus(menuSb.toString());
//				}
//				modelAndView.addObject("roles",roles);
//			}
//		}catch(Exception e){
//			modelAndView.setViewName("404");
//			e.printStackTrace();
//		}
		return modelAndView;
	}
	
	@RequestMapping("/searchRole")
	public ModelAndView searchRole(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("role/manager");
		List<Role> roles = new ArrayList<Role>();
		try{
			String rolename = request.getParameter("rolename");
			if(!Strings.isNullOrEmpty(rolename)){
				Role role = roleService.queryRoleByName(rolename);
				if (Objects.nonNull(role)) {
					roles.add(role);
				}
			}
			request.setAttribute("roles", roles);
		}catch(Exception e){
			modelAndView.setViewName("404");
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/addRole",method=RequestMethod.GET)
	public ModelAndView addRole_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("role/addRole");
		return modelAndView;
	}
	
	@RequestMapping(value="/addRole",method=RequestMethod.POST)
	public String addRole_post(HttpServletRequest request, HttpServletResponse response){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/role_manage";
	}
	
	@RequestMapping(value="/editRole", method=RequestMethod.GET)
	public ModelAndView editRole_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("role/editRole");
		try{
//			String id = request.getParameter("id");
//			User user = userService.queryUserByID(id);
//			modelAndView.addObject("user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value="/editRole", method=RequestMethod.POST)
	public String editRole_post(HttpServletRequest request, HttpServletResponse response){
		try{

		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/role_manage";
	}
	
*/}
