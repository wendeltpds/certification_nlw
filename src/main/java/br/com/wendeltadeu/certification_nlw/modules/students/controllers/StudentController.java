package br.com.wendeltadeu.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.wendeltadeu.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import br.com.wendeltadeu.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import lombok.var;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyIfHasCertificationDTO){
         
        var result = this.verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
        if (result) {
            return "usuario ja fez a prova";
        }
        return "usuario pode fazer a prova";
    }
}
