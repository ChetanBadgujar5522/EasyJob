package in.chetan.EasyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-posts")
public class JobPostController {
    
    @Autowired
    private JobPostService jobPostService;

    @Autowired
    private ApplicationService applicationService; 

    @PostMapping("/post")
    public JobPost postJob(@RequestBody JobPost jobPost) {
        return jobPostService.postJob(jobPost);
    }

    @GetMapping("/")
    public List<JobPost> getAllJobs() {
        return jobPostService.getAllJobs();
    }

    @GetMapping("/{jobPostId}/applicants")
    public List<Application> getApplicantsForJobPost(@PathVariable Long jobPostId) {
        return applicationService.getApplicationsForJob(jobPostId); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPost(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.noContent().build();
    }
}
