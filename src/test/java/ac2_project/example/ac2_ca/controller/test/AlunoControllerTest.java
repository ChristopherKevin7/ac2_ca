package ac2_project.example.ac2_ca.controller.test;

import ac2_project.example.ac2_ca.controller.AlunoController;
import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.service.AlunoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        // Arrange
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setUsername("John Doe");
        alunoDTO.setEmail("johndoe@example.com");
        int moedas = 100;
        int vouchers = 5;

        Aluno aluno = new Aluno();
        aluno.setUsername(alunoDTO.getUsername());
        aluno.setEmail(null); // Suponha que o email seja configurado no serviço

        when(alunoService.createUser(alunoDTO, moedas, vouchers)).thenReturn(aluno);

        // Act
        ResponseEntity<Aluno> response = alunoController.createUser(alunoDTO, moedas, vouchers);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(aluno, response.getBody());
        verify(alunoService, times(1)).createUser(alunoDTO, moedas, vouchers);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        AlunoDTO alunoDTO1 = new AlunoDTO();
        alunoDTO1.setUsername("John Doe");
        alunoDTO1.setEmail("johndoe@example.com");

        AlunoDTO alunoDTO2 = new AlunoDTO();
        alunoDTO2.setUsername("Jane Smith");
        alunoDTO2.setEmail("janesmith@example.com");

        List<AlunoDTO> alunos = Arrays.asList(alunoDTO1, alunoDTO2);

        when(alunoService.getAllUsers()).thenReturn(alunos);

        // Act
        ResponseEntity<List<AlunoDTO>> response = alunoController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alunos, response.getBody());
        verify(alunoService, times(1)).getAllUsers();
    }
}
