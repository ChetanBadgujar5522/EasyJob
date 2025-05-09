package in.chetan.EasyJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application applyForJob(Application application, MultipartFile file) {
        try {
            byte[] cvData = file.getBytes();
            application.setCv(cvData); 
            return applicationRepository.save(application); 
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save the CV.", e);
        }
    }

    public List<Application> getApplicationsForJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
}
