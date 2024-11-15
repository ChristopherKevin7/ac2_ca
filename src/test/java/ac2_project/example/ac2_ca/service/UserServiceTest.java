package ac2_project.example.ac2_ca.service;

import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.repository.Aluno_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private Aluno_Repository userRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Configurando dados fictícios
        Aluno user1 = new Aluno();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setEmail(new Aluno_Email("user1@example.com"));

        Aluno user2 = new Aluno();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setEmail(new Aluno_Email("user2@example.com"));

        // Mock do comportamento do repositório
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Chamada ao método de serviço
        List<AlunoDTO> users = alunoService.getAllUsers();

        // Verificação dos resultados
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
        assertEquals("user1@example.com", users.get(0).getEmail());
    }
}