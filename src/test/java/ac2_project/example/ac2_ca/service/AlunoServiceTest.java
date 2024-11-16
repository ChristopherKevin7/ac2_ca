package ac2_project.example.ac2_ca.service;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.BeneficioPremium;
import ac2_project.example.ac2_ca.repository.Aluno_Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    private Aluno_Repository userRepository;

    @InjectMocks
    private AlunoService alunoService;

    private Aluno aluno;
    private AlunoDTO alunoDTO;

    @BeforeEach
    void setUp() {
        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setUsername("John Doe");
        aluno.setEmail(new Aluno_Email("johndoe@example.com"));
        aluno.setBeneficioPremium(new BeneficioPremium(100, 10));

        alunoDTO = new AlunoDTO();
        alunoDTO.setUsername("John Doe");
        alunoDTO.setEmail("johndoe@example.com");
    }

    @Test
    void testCreateUser() {
        // Configura o mock para o método save do repositório
        when(userRepository.save(any(Aluno.class))).thenReturn(aluno);

        // Executa o método createUser
        Aluno createdAluno = alunoService.createUser(alunoDTO, 100, 10);

        // Verifica se os valores foram configurados corretamente
        assertEquals(aluno.getUsername(), createdAluno.getUsername());
        assertEquals(aluno.getEmail().getEmailAddress(), createdAluno.getEmail().getEmailAddress());
        assertEquals(aluno.getBeneficioPremium().getMoedas(), createdAluno.getBeneficioPremium().getMoedas());
        assertEquals(aluno.getBeneficioPremium().getVouchers(), createdAluno.getBeneficioPremium().getVouchers());
    }

    @Test
    void testGetAllUsers() {
        // Configura o mock para o método findAll do repositório
        when(userRepository.findAll()).thenReturn(Arrays.asList(aluno));

        // Executa o método getAllUsers
        List<AlunoDTO> users = alunoService.getAllUsers();

        // Verifica se a lista contém o usuário correto
        assertEquals(1, users.size());
        assertEquals(aluno.getUsername(), users.get(0).getUsername());
        assertEquals(aluno.getEmail().getEmailAddress(), users.get(0).getEmail());
    }
}
