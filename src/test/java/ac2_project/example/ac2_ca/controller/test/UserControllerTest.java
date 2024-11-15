package ac2_project.example.ac2_ca.controller.test;

import ac2_project.example.ac2_ca.controller.AlunoController;
import ac2_project.example.ac2_ca.dto.AlunoDTO;
import ac2_project.example.ac2_ca.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class) // Carrega apenas o contexto da camada web
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService; // Injeta um mock do serviço, substituindo a necessidade do repositório

    @Test
    public void testGetUsers() throws Exception {
        // Configura o comportamento do mock para o método de serviço
        AlunoDTO mockUser = new AlunoDTO();
        mockUser.setId(1L);
        mockUser.setUsername("JohnDoe");
        mockUser.setEmail("john@example.com");
        
        List<AlunoDTO> mockUsers = List.of(mockUser);
        Mockito.when(alunoService.getAllUsers()).thenReturn(mockUsers);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/users") // Corrige o caminho da URL
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("JohnDoe")) // Corrige o nome do campo
                .andExpect(jsonPath("$[0].email").value("john@example.com"));
    }
}