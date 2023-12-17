package viaVemMvc.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "Usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Passagens passagem;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String senha;
	
	public Usuarios(int id, Passagens passagem, String nome, String email, String senha) {
		super();
		this.id = id;
		this.passagem=passagem;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public Usuarios() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Passagens getPassagens() {
		return passagem;
	}
	public void setPassagens(Passagens passagem) {
		this.passagem=passagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		    this.senha = senha;
	}
	

}
