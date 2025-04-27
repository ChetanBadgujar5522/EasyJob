package in.chetan.EasyJob;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPortalController {

    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    @GetMapping("/job_seeker/login")
    public String jobSeekerLogin() {
        return "job_seeker_login"; 
    }

    @GetMapping("/job_seeker/register")
    public String jobSeekerRegister() {
        return "job_seeker_register"; 
    }

    @GetMapping("/job_seeker/dashboard")
    public String jobSeekerDashboard() {
        return "job_seeker_dashboard"; 
    }

    @GetMapping("/recruiter/login")
    public String recruiterLogin() {
        return "recruiter_login"; 
    }

    @GetMapping("/recruiter/register")
    public String recruiterRegister() {
        return "recruiter_register";
    }

    @GetMapping("/recruiter/dashboard")
    public String recruiterDashboard() {
        return "recruiter_dashboard";
    }
}
