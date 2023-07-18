package com.learn.controller;

import com.learn.entity.User;
import com.learn.request.loginRequest;
import com.learn.request.signupRequest;
import com.learn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/user")
public class UserController {

//  @Autowired는 자동으로 의존성을 주입하는것. (final을 사용하면안됨.)
//  public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    이런 코드를 적을 필요가없다 하지만 다른곳에서도 쉽게 접근이 가능해서 잘 사용안함.
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/signup")
    public ModelAndView signUp(ModelAndView mav){
        mav.setViewName("/signUp");
        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView insertUser(ModelAndView mav, @ModelAttribute signupRequest req){
        userService.signUp(req);
        mav.setViewName("/login");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView showlogin(ModelAndView mav){
        mav.setViewName("/login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView mav, @ModelAttribute loginRequest req, HttpSession session){
        User login = userService.login(req);
        session.setAttribute("seq", login.getSeq());
        session.setAttribute("name", login.getName());
        mav.setViewName("/main");
        return mav;
    }

//    @PostMapping("/deposit")
//    public ModelAndView likeUpdate(
//            @RequestParam("todoid") Integer todoid,
//            HttpSession session,
//            ModelAndView mav){
//        HeartSupport heartSupport = new HeartSupport(
//                (Integer) session.getAttribute("id"), todoid, null
//        );
//        try {
//            todoService.clickHeart(heartSupport);
//        } catch (Exception e) {
//
//        }
//        mav.setViewName("redirect:/main");
//        return mav;
//
//    }



}
