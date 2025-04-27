package in.chetan.EasyJob;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	List<Application> findByJobId(Long jobId);

}
