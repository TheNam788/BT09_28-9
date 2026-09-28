package vn.iotstar.example2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {

    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
