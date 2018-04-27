package com.ziv.springboot.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MenuNodeController {/*

	@Autowired
	private MenuService menuNodeService;
	
	@RequestMapping("/menu_manage")
	public ModelAndView menu_manage(ModelAndView modelAndView){
		modelAndView.setViewName("menu/manager");
		List<Menu> menuNodes = new ArrayList<Menu>();
		try{
//			menuNodes = menuNodeService.queryNodes();
//			modelAndView.addObject("menuNodes", menuNodes);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("/searchMenu")
	public ModelAndView searchMenu(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("menu/manager");
//		List<Menu> menus = new ArrayList<Menu>();
//		try{
//			String menuname = request.getParameter("menuname");
//			if(!Strings.isNullOrEmpty(menuname)){
//				Menu menu = menuService.queryMenuByName(menuname);
//				if (Objects.nonNull(menu)) {
//					menus.add(menu);
//				}
//			}
//			request.setAttribute("menus", menus);
//		}catch(Exception e){
//			modelAndView.setViewName("404");
//			e.printStackTrace();
//		}
		return modelAndView;
	}
	
	@RequestMapping(value="/addMenu",method=RequestMethod.GET)
	public ModelAndView addMenu_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("menu/addMenu");
		return modelAndView;
	}
	
	@RequestMapping(value="/addMenu",method=RequestMethod.POST)
	public String addMenu_post(HttpServletRequest request, HttpServletResponse response){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/menu_manage";
	}
	
	@RequestMapping(value="/editMenu", method=RequestMethod.GET)
	public ModelAndView editMenu_get(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
		modelAndView.setViewName("menu/editMenu");
		try{
//			String id = request.getParameter("id");
//			User user = userService.queryUserByID(id);
//			modelAndView.addObject("user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value="/editMenu", method=RequestMethod.POST)
	public String editMenu_post(HttpServletRequest request, HttpServletResponse response){
		try{

		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/menu_manage";
	}
	
	
*/}
