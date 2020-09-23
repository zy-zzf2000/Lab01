package zy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zy.demo.entity.User;
import zy.demo.mapper.UserMapper;
import zy.demo.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value="",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        User user = new User();
        user.setId(0);
        user.setPassword("test");
        view.addObject("user",user);
        return view;
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public ModelAndView dologin(@ModelAttribute User user){
        ModelAndView view_success = new ModelAndView();
        ModelAndView view_fail = new ModelAndView();

        view_success.setViewName("home");
        view_fail.setViewName("fail");

        int id =user.getId();
        String pwd = user.getPassword();

        if(userService.match(id,pwd)){
            return view_success;
        }
        else{
            return view_fail;
        }
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView view = new ModelAndView();
        view.setViewName("register");
        User user = new User();
        user.setId(0);
        user.setPassword("test");
        view.addObject("user",user);
        return view;
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public  String doregister(@ModelAttribute User user){

        userService.register(user);
        return "redirect:/user";
    }




}
