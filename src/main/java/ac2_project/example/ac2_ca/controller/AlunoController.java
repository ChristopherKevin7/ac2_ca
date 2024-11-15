package ac2_project.example.ac2_ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.service.AlunoService;

@RestController
@RequestMapping("/api/users")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createUser(@RequestBody AlunoDTO alunoDTO,
                                            @RequestParam int moedas,
                                            @RequestParam int vouchers) {
        Aluno aluno = alunoService.createUser(alunoDTO, moedas, vouchers);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAllUsers() {
        List<AlunoDTO> users = alunoService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
