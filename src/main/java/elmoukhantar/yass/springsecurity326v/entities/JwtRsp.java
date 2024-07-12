package elmoukhantar.yass.springsecurity326v.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRsp {
    private String username;
    private String jwttoken;
}
