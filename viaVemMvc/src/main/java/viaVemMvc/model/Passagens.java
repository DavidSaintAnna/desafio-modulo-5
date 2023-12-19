package viaVemMvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Passagens")
public class Passagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Aeroportos aeroporto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float preco;

    // Additional string columns for dates
    @Column(nullable = false)
    private String dataDeChegada;

    @Column(nullable = false)
    private String dataDeSaida;

    @Column(nullable = false)
    private String dataDeRetorno;

    // Constructors, Getters, Setters
    // ...

    public Passagens(int id, Aeroportos aeroporto, String nome, float preco, String dataDeChegada, String dataDeSaida, String dataDeRetorno) {
        super();
        this.id = id;
        this.aeroporto = aeroporto;
        this.nome = nome;
        this.preco = preco;
        this.dataDeChegada = dataDeChegada;
        this.dataDeSaida = dataDeSaida;
        this.dataDeRetorno = dataDeRetorno;
    }

    public Passagens() {
        super();
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aeroportos getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(Aeroportos aeroporto) {
		this.aeroporto = aeroporto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

    // Getters and Setters for the additional date fields
    public String getDataDeChegada() {
        return dataDeChegada;
    }

    public void setDataDeChegada(String dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
    }

    public String getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(String dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getDataDeRetorno() {
        return dataDeRetorno;
    }

    public void setDataDeRetorno(String dataDeRetorno) {
        this.dataDeRetorno = dataDeRetorno;
    }
    
    // Other getters and setters
    // ...
}
