package idusw.springboot.boardksh.controller;

import idusw.springboot.boardksh.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    /*
    Field Injection (필드 주입) : Spring Framework 에게 MemoService형 객체를 주입(해줄 것을 알림)
    @Autowired
    MemoService memoService = new MemoServiceImpl();
     */
    @GetMapping("/") //localhost:port로 요청을 하면 getAdmin() 메소드를 호출하여 처리하고 /admin/index view에게 전달
    public String getAdmin() {
        return "/admin/index";
    }


    @GetMapping("404")
    public String get404() {
        return "/404";
    }

    @GetMapping("blank")
    public String getBlanks() {
        return "/blank";
    }

    @GetMapping("charts")
    public String getCharts() {
        return "/charts";
    }

    @GetMapping("utilities-animation")
    public String getAnimations() {
        return "/utilities-animation";
    }

    @GetMapping("utilities-border")
    public String getBorders() {
        return "/utilities-border";
    }

    @GetMapping("utilities-color")
    public String getColors() {
        return "/utilities-color";
    }

    @GetMapping("utilities-other")
    public String getOthers() {
        return "/utilities-other";
    }

    @GetMapping("buttons") // 자원을 접근하는 개념 , /admin/buttons
    public String getButtons() {
        return "/admin/buttons";
    }

    @GetMapping("cards") // 자원을 접근하는 개념
    public String getCards() {
        return "/admin/cards";
    }
}
