package com.saadmsf.patientsmvc.web;

import com.saadmsf.patientsmvc.entites.Patient;
import com.saadmsf.patientsmvc.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
@GetMapping(path = "/index")
private String patients(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "6") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){
    Page<Patient> pagePatients=patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
    model.addAttribute("listPatients",pagePatients.getContent());
    model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
    model.addAttribute("currentPage",page);
    model.addAttribute("keyword",keyword);
 return "patients";
}
@GetMapping("delete")
public String delete(Long id,String keyword,int page){
    patientRepository.deleteById(id);
    return "redirect:/index?page="+page+"&keyword="+keyword;

}
@GetMapping("/")
    public String home(){
    return "redirect:/index";
}
}
