package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 관련 컨트롤러에서 매핑된 것이 있으면 띄워주고 없을땐 static파일 찾아서 보여줌
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
