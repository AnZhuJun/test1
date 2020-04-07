package test1.test1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test1.test1.bean.Teacher;
import test1.test1.service.SecurityService;
import test1.test1.service.TeacherService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class WebController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TeacherService teacherService;

    @Autowired
    SecurityService securityService;


    @GetMapping("/login")
    public String login(Model model,String error,String logout){
        if(error != null){
            model.addAttribute("error","Your username and password is invalid.");
        }

        if(logout != null){
            model.addAttribute("message","You have been logged out.");
        }

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String welcome(Principal principal, Model model, HttpSession session){
        String temp =  principal.getName();
        session.setAttribute("name", principal.getName());
        model.addAttribute("name", principal.getName());
        if(temp.equals("admin"))
            return "admin/common/adminNavigator";
        else
            return "teacher/teachermain/adminNavigator";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("teacher",new Teacher());
        return "registration";
    }


    @PostMapping("/registration")
    public String registration(Teacher teacher,Model model){

        teacherService.addTeacher(teacher);
        securityService.autoLogin(teacher.getUsername(),teacher.getPassword());

        return "redirect:/welcome";
    }
}
