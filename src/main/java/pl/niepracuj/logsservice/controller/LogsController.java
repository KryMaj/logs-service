package pl.niepracuj.logsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {

    private final LogService logService;
    private final LogMapper logMapper;

    @PostMapping
    public LogDto createLOg(@RequestBody LogDto logDto){
        return logMapper.toDto(logService);
    }
}
