package pl.niepracuj.logsservice.model.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {

    private Long id;

    private LocalDateTime loggedOn;

    private String message;
}
