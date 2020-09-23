package zy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zy.demo.entity.Nation;
import zy.demo.service.NationService;

@Controller
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private NationService nationService;

    @RequestMapping("/list")
    public ModelAndView nationlist(){
        ModelAndView view = new ModelAndView();
        view.setViewName("list");
        view.addObject("nations",nationService.select_all());
        return view;
    }

    @RequestMapping(value = "id",method = RequestMethod.GET)
    public ModelAndView select_by_id(){
        ModelAndView view = new ModelAndView();
        view.setViewName("queryid");
        Nation nation=new Nation();
        view.addObject("nation",nation);
        return view;
    }


    @RequestMapping(value = "id",method = RequestMethod.POST)
    public ModelAndView doselect_by_id(@ModelAttribute Nation nation){
        ModelAndView view = new ModelAndView();
        view.setViewName("list");
        view.addObject("nations",nationService.select_one(nation.getId()));
        return view;
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView view = new ModelAndView();
        view.setViewName("add");
        Nation nation=new Nation();
        view.addObject("nation",nation);
        return view;
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String doadd(@ModelAttribute Nation nation){
        nationService.add_nation(nation);
        return "redirect:/nation/list";
    }

}
