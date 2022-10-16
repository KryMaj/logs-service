package pl.niepracuj.logsservice.service;

import pl.niepracuj.logsservice.model.dto.LogDto;

public interface LogService {

    LogDto saveLog(LogDto logDto);
}
