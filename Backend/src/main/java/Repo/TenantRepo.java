package Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import ModelClasses.tenant;

@Repository
public interface TenantRepo extends JpaRepositoryImplementation<tenant, Long>{

}
