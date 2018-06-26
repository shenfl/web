package com.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shenfl on 2018/6/18
 * 当这样传的时候就不能在spring中配置InternalResourceViewResolver
 */
@Controller
public class SecondController {
    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public ModelAndView second() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "shenfl");
        modelAndView.addObject("msg", "lulu");
        modelAndView.setViewName("/WEB-INF/jsp/second.jsp");
        return modelAndView;
    }
}
