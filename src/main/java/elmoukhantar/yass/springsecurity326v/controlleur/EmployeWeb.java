package elmoukhantar.yass.springsecurity326v.controlleur;

import elmoukhantar.yass.springsecurity326v.entities.Employe;
import elmoukhantar.yass.springsecurity326v.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api1")
@AllArgsConstructor
public class EmployeWeb {

private EmployeService employeService;

@GetMapping("/employes")
public List<Employe> get(){
    return employeService.getallemploye();
}
}
