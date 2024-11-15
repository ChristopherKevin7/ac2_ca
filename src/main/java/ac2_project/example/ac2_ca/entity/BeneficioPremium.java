package ac2_project.example.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class BeneficioPremium {

    private int moedas;
    private int vouchers;

    // Construtor padrão necessário para o JPA
    protected BeneficioPremium() {}

    public BeneficioPremium(int moedas, int vouchers) {
        if (moedas < 0 || vouchers < 0) {
            throw new IllegalArgumentException("Moedas e vouchers não podem ser negativos");
        }
        this.moedas = moedas;
        this.vouchers = vouchers;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        if (moedas < 0) {
            throw new IllegalArgumentException("Moedas não podem ser negativas");
        }
        this.moedas = moedas;
    }

    public int getVouchers() {
        return vouchers;
    }

    public void setVouchers(int vouchers) {
        if (vouchers < 0) {
            throw new IllegalArgumentException("Vouchers não podem ser negativos");
        }
        this.vouchers = vouchers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficioPremium that = (BeneficioPremium) o;
        return moedas == that.moedas && vouchers == that.vouchers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moedas, vouchers);
    }

    @Override
    public String toString() {
        return "BeneficioPremium{" +
                "moedas=" + moedas +
                ", vouchers=" + vouchers +
                '}';
    }
}
