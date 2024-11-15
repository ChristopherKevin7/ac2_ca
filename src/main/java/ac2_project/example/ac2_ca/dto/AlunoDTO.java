package ac2_project.example.ac2_ca.dto;

import ac2_project.example.ac2_ca.entity.Aluno;
import ac2_project.example.ac2_ca.entity.BeneficioPremium;

public class AlunoDTO {

    private Long id;
    private String username;
    private String email;

    // Construtor vazio
    public AlunoDTO() {}

    // Construtor com todos os parâmetros
    public AlunoDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    // Método de conversão de User para UserDTO
    public static AlunoDTO fromEntity(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setUsername(aluno.getUsername());

        // Certifique-se de que o método getEmailAddress() existe na classe User_Email
        if (aluno.getEmail() != null) {
            alunoDTO.setEmail(aluno.getEmail().getEmailAddress());
        }

        return alunoDTO;
    }
}
