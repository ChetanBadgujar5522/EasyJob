package in.chetan.EasyJob;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin_login";
    }
}
