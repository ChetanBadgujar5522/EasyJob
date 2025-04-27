package in.chetan.EasyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest request) {
        try {
            if (adminService.login(request.getEmail(), request.getPassword())) {
                return ResponseEntity.ok("Login successful."); 
            } else {
                return ResponseEntity.status(401).body("Invalid credentials."); 
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(403).body(e.getMessage()); 
        }
    }

    @PostMapping("/block-job-seeker/{id}")
    public ResponseEntity<String> blockJobSeeker(@PathVariable Long id) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElse(null);
        if (jobSeeker != null) {
            jobSeeker.setBlocked(true);
            jobSeekerRepository.save(jobSeeker);
            return ResponseEntity.ok("Job seeker blocked successfully.");
        }
        return ResponseEntity.status(404).body("Job seeker not found.");
    }

    @PostMapping("/unblock-job-seeker/{id}")
    public ResponseEntity<String> unblockJobSeeker(@PathVariable Long id) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElse(null);
        if (jobSeeker != null) {
            jobSeeker.setBlocked(false);
            jobSeekerRepository.save(jobSeeker);
            return ResponseEntity.ok("Job seeker unblocked successfully.");
        }
        return ResponseEntity.status(404).body("Job seeker not found.");
    }

    @PostMapping("/block-recruiter/{id}")
    public ResponseEntity<String> blockRecruiter(@PathVariable Long id) {
        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);
        if (recruiter != null) {
            recruiter.setBlocked(true);
            recruiterRepository.save(recruiter);
            return ResponseEntity.ok("Recruiter blocked successfully.");
        }
        return ResponseEntity.status(404).body("Recruiter not found.");
    }

    @PostMapping("/unblock-recruiter/{id}")
    public ResponseEntity<String> unblockRecruiter(@PathVariable Long id) {
        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);
        if (recruiter != null) {
            recruiter.setBlocked(false);
            recruiterRepository.save(recruiter);
            return ResponseEntity.ok("Recruiter unblocked successfully.");
        }
        return ResponseEntity.status(404).body("Recruiter not found.");
    }

    @GetMapping("/job-seekers")
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return ResponseEntity.ok(jobSeekers);
    }

    @GetMapping("/recruiters")
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return ResponseEntity.ok(recruiters);
    }
}
class AdminLoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
