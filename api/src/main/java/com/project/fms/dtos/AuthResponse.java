package com.project.fms.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("RefreshToken")
    private String refreshToken;

    private AuthUser authUser;
}
