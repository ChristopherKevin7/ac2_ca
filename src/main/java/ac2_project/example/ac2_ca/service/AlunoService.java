package ac2_project.example.ac2_ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.BeneficioPremium;
import ac2_project.example.ac2_ca.repository.Aluno_Repository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private Aluno_Repository userRepository;

    public Aluno createUser(AlunoDTO alunoDTO, int moedas, int vouchers) {
        Aluno aluno = new Aluno();
        aluno.setUsername(alunoDTO.getUsername());
        aluno.setEmail(new Aluno_Email(alunoDTO.getEmail()));

        // Configura o benefício Premium
        aluno.setBeneficioPremium(new BeneficioPremium(moedas, vouchers));

        return userRepository.save(aluno);
    }

    public List<AlunoDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> {
                    AlunoDTO dto = new AlunoDTO();
                    dto.setUsername(user.getUsername());
                    dto.setEmail(user.getEmail().getEmailAddress());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
