package elmoukhantar.yass.springsecurity326v.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtRqst {

    private String username;
    private String password;
}
