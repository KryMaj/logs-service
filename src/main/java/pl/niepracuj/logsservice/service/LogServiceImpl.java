package pl.niepracuj.logsservice.service;
import lombok.*;
import org.springframework.stereotype.Service;
import pl.niepracuj.logsservice.model.dto.LogDto;
import pl.niepracuj.logsservice.model.entity.Log;
import pl.niepracuj.logsservice.model.mapper.LogMapper;
import pl.niepracuj.logsservice.repository.LogRepository;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogMapper logMapper;

    private final LogRepository logRepository;

    @Override
    public LogDto saveLog(LogDto logDto) {
        Log log = logMapper.toNewEntity(logDto);
        return logMapper.toDto(logRepository.save(log));
    }
}