package ac2_project.example.ac2_ca.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;
import ac2_project.example.ac2_ca.entity.BeneficioPremium;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new Aluno();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        aluno.setId(id);
        assertEquals(id, aluno.getId());
    }

    @Test
    void testUsernameGetterAndSetter() {
        String username = "John Doe";
        aluno.setUsername(username);
        assertEquals(username, aluno.getUsername());
    }

    @Test
    void testEmailGetterAndSetter() {
        Aluno_Email email = new Aluno_Email("johndoe@example.com");
        aluno.setEmail(email);
        assertEquals(email, aluno.getEmail());
    }

    @Test
    void testBeneficioPremiumGetterAndSetter() {
        BeneficioPremium beneficioPremium = new BeneficioPremium(100, 5);
        aluno.setBeneficioPremium(beneficioPremium);
        assertEquals(beneficioPremium, aluno.getBeneficioPremium());
    }

    @Test
    void testDefaultValues() {
        // Verifica se os valores iniciais são nulos antes de serem configurados
        assertNull(aluno.getId());
        assertNull(aluno.getUsername());
        assertNull(aluno.getEmail());
        assertNull(aluno.getBeneficioPremium());
    }
}
