package demo.spring.rest.repository;

import demo.spring.rest.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(
        value = "SELECT a.CONTACT_ID, a.ID, a.DT_CREATED, a.PRODUCT_NAME "
            + "FROM Application as a "
            + "WHERE a.CONTACT_ID = ?1 "
            + "ORDER BY DT_CREATED DESC "
            + "LIMIT 1;",
        nativeQuery = true
    )
    Application getLastApplicationContact(Integer contactId);
}
