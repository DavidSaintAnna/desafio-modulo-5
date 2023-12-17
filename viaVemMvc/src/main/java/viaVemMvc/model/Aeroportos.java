package viaVemMvc.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "Aeroportos")
public class Aeroportos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cidade;
	@Column(nullable=false)
	private String pais;
	
	public Aeroportos(int id, String nome, String cidade, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.pais = pais;
	}
	public Aeroportos() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		    this.pais = pais;
	}
	

}
