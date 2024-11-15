package ac2_project.example.ac2_ca.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    private String username;

    @Embedded
    private Aluno_Email email;
    
    @Embedded
    private BeneficioPremium beneficioPremium;

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

    public Aluno_Email getEmail() {
        return email;
    }

    public void setEmail(Aluno_Email email) {
        this.email = email;
    }
    
 // Getters e Setters para beneficioPremium
    public BeneficioPremium getBeneficioPremium() {
        return beneficioPremium;
    }

    public void setBeneficioPremium(BeneficioPremium beneficioPremium) {
        this.beneficioPremium = beneficioPremium;
    }
}