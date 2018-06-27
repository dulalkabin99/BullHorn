package com.dulal.basic_bullhorn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ContentRepo contentRepo;

    @RequestMapping("/")
    public String contentList(Model model){
        model.addAttribute("contents", contentRepo.findAll());
        return "contentlist";

    }

     @GetMapping("/add")
    public String form(Model model){
        model.addAttribute("content", new Bullhorn());
        return "addform";
     }

     @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute Bullhorn bullhorn, BindingResult result){
        if(result.hasErrors()){
            return "addform";
        }
        contentRepo.save(bullhorn);
        return "redirect:/";

     }

     @RequestMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model){
    model.addAttribute("content", contentRepo.findById(id));
        return "details";
     }

     @RequestMapping("/update/{id}")
    public String updateContent(@PathVariable("id") long id, Model model){
         model.addAttribute("content", contentRepo.findById(id));
         return "addform";


     }

}
