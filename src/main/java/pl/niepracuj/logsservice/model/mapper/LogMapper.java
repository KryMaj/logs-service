package pl.niepracuj.logsservice.model.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.niepracuj.logsservice.model.dto.LogDto;
import pl.niepracuj.logsservice.model.entity.Log;

@Mapper(componentModel = "spring")
public interface LogMapper {

    LogDto toDto(Log log);

    Log toNewEntity(LogDto logDto);
}