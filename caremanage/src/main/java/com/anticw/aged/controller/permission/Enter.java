package com.anticw.aged.controller.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mxc on 2015/7/22.</br>
 */
@Controller
public class Enter {
    @RequestMapping("/")
    public String enter(){
        return "redirect:"+"/permission/toLogin";
    }
}
