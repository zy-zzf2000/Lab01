package zy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
//---------------------------------查询功能块-------------------------------------------
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

    @RequestMapping(value = "name",method = RequestMethod.GET)
    public ModelAndView select_by_name(){
        ModelAndView view = new ModelAndView();
        view.setViewName("queryname");
        Nation nation=new Nation();
        view.addObject("nation",nation);
        return view;
    }


    @RequestMapping(value = "name",method = RequestMethod.POST)
    public ModelAndView doselect_by_name(@ModelAttribute Nation nation){
        ModelAndView view = new ModelAndView();
        view.setViewName("list");
        view.addObject("nations",nationService.select_by_name(nation.getName()));
        return view;
    }

    @RequestMapping(value = "population",method = RequestMethod.GET)
    public ModelAndView select_by_pop(){
        ModelAndView view = new ModelAndView();
        view.setViewName("querypopulation");
        Nation nation=new Nation();
        view.addObject("nation",nation);
        return view;
    }


    @RequestMapping(value = "population",method = RequestMethod.POST)
    public ModelAndView doselect_by_pop(@ModelAttribute Nation nation){
        ModelAndView view = new ModelAndView();
        view.setViewName("list");
        view.addObject("nations",nationService.select_by_pop(nation.getMale_population()));
        return view;
    }

    //---------------------------------------------------------------------------------------------

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

    @RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        nationService.delete_nation(id);
        return "redirect:/nation/list";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
        ModelAndView view = new ModelAndView();
        view.setViewName("update");
        Nation nation=new Nation();
        nation.setId(id);
        view.addObject("nation",nation);
        return view;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String doupdate(@ModelAttribute Nation nation){
        nationService.update_nation(nation);
        return "redirect:/nation/list";
    }



}
