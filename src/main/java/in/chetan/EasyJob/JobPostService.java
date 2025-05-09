package in.chetan.EasyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;

    public JobPost postJob(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobPostRepository.findAll();
    }

    public List<JobPost> getJobsByRecruiter(Long recruiterId) {
        return jobPostRepository.findByRecruiterId(recruiterId);
    }
    
    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }

}

