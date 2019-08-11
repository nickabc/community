package life.nick.community.controller;

import life.nick.community.dto.QuestionDTO;
import life.nick.community.mapper.UserMapper;
import life.nick.community.model.User;
import life.nick.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
            Model model) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        //获取question
        List<QuestionDTO> questions = questionService.list();
        model.addAttribute("questions",questions);


        return "index";
    }












    @GetMapping("test")
    public String myTest(String token){
        User user = userMapper.findByToken(token);
        return user.getName();
    }
}
