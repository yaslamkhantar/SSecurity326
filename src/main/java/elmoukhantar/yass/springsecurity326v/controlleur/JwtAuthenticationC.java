package elmoukhantar.yass.springsecurity326v.controlleur;

import elmoukhantar.yass.springsecurity326v.entities.JwtRqst;
import elmoukhantar.yass.springsecurity326v.entities.JwtRsp;
import elmoukhantar.yass.springsecurity326v.jwt.JwtH;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class JwtAuthenticationC {
    private UserDetailsService userDetailsService;
    private AuthenticationManager manager;
    private JwtH jwtH;


    @PostMapping("/authenticate")
    public ResponseEntity<JwtRsp> login(@RequestBody JwtRqst request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtH.generateToken(userDetails);

        JwtRsp response = JwtRsp.builder()
                .jwttoken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("error de validite de credentialite");
        }

    }
}
