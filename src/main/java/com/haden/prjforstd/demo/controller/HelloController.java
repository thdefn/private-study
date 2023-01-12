package com.haden.prjforstd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit")
public class HelloController {
    private static long visitCount = 0;

    @GetMapping("/dynamic")
    public String dynamicEntry(Model model){
        visitCount++;
        model.addAttribute("visits",visitCount);
        return "hello-visit";
    }

    @GetMapping
    public String staticEntry(){
        return "redirect:/hello.html";
    }



}
