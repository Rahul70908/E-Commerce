package com.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetailsDto {

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
