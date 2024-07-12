package elmoukhantar.yass.springsecurity326v.service;

import elmoukhantar.yass.springsecurity326v.entities.Employe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeService {

    private List<Employe> employeList=new ArrayList<>();

    public EmployeService() {
        employeList.add(new Employe(UUID.randomUUID().toString(),"yassine","yassine.rwx@gmail.com"));
        employeList.add(new Employe(UUID.randomUUID().toString(),"souad","souad.pin@gmail.com"));
    }

    public List<Employe> getallemploye(){
        return employeList;
    }
}
