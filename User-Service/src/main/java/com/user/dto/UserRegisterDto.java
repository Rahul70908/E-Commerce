package com.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.user.validator.ValidateRegisterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ValidateRegisterDto
public class UserRegisterDto {

    private String email;

    private String phone;
}
