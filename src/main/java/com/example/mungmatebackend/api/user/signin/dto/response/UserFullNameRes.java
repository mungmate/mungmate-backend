package com.example.mungmatebackend.api.user.signin.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFullNameRes {

    @NotBlank(message = "해당 값은 필수 입력 값 입니다.")
    @Schema(example = "200")
    private String statusCode;

    @NotBlank(message = "해당 값은 필수 입력 값 입니다.")
    @Schema(example = "귀여운 댕댕이")
    private String fullName;
}
