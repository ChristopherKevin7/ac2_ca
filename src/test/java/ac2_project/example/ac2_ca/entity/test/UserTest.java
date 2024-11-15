package ac2_project.example.ac2_ca.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.Aluno_Email;

public class UserTest {
	
	 @Test
	    void testSetAndGetValidEmail() {
	        Aluno aluno = new Aluno();
	        Aluno_Email email = new Aluno_Email("test@example.com");
	        aluno.setEmail(email);
	        
	        assertEquals(email, aluno.getEmail());
	    }

	    @Test
	    void testInvalidEmailThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Aluno_Email("invalid-email");
	        });
	    }
	
	
	
	
	
	

}
