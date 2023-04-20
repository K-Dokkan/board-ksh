package idusw.springboot.boardksh.controller;

import idusw.springboot.boardksh.domain.Member;
import idusw.springboot.boardksh.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    MemberService memberService;    // 생성자 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("login")
    public String getLogin() {
        return "/members/login";
    }

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        // Member 형의 객체를 생성
        model.addAttribute("member", Member.builder().build());
        return "/members/register"; // view resolving
    }
    @PostMapping("register")
    public String registerMember(@ModelAttribute("member") Member m, Model model){
        if(memberService.create(m) > 0)
            return "redirect:/members/login"; // 홈으로 재지정함 : 컨트롤러에게 재지정
        else
            return "redirect:/members/register";
    }

    @GetMapping("forgot")
    public String getPasswd() {
        return "/members/forgot-password";
    }
}
