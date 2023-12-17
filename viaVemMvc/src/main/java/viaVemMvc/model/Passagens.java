package viaVemMvc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Passagens")
public class Passagens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Aeroportos aeroporto;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date dataDeChegada;
	@Column(nullable=false)
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date dataDeSaida;
	@Column(nullable=false)
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date dataDeRetorno;
	@Column(nullable=false)
	private float preco;
	
	public Passagens(int id, Aeroportos aeroporto, String nome, Date dataDeChegada, Date dataDeSaida,
			Date dataDeRetorno, float preco) {
		super();
		this.id = id;
		this.aeroporto = aeroporto;
		this.nome = nome;
		this.dataDeChegada = dataDeChegada;
		this.dataDeSaida = dataDeSaida;
		this.dataDeRetorno = dataDeRetorno;
		this.preco = preco;
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
	public Date getDatadeChegada() {
		return dataDeChegada;
	}
	public void setDatadeChegada(Date dataDeChegada) {
		this.dataDeChegada = dataDeChegada;
	}
	public Date getDatadeSaida() {
		return dataDeSaida;
	}
	public void setDatadeSaida(Date dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}
	public Date getDatadeRetorno() {
		return dataDeRetorno;
	}
	public void setDatadeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	

}
