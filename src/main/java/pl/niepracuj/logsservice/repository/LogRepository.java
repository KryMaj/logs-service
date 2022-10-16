package pl.niepracuj.logsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niepracuj.logsservice.model.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}