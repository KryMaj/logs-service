package pl.niepracuj.logsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.niepracuj.logsservice.model.dto.LogDto;
import pl.niepracuj.logsservice.model.mapper.LogMapper;
import pl.niepracuj.logsservice.service.LogService;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {

    private final LogService logService;

    @PostMapping
    public LogDto createLog(@RequestBody LogDto logDto){
        return logService.saveLog(logDto);
    }
}
