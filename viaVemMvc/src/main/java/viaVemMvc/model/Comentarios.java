package viaVemMvc.model;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "Comentarios")
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Usuarios usuario;
	@Column(nullable=false)
	private String comentario;
	@Column(nullable=false)
	private Date dataDePublicacao;
	public Comentarios(int id, Usuarios usuario, String comentario, Date dataDePublicacao) {
		super();
		this.id = id;
		this.usuario=usuario;
		this.comentario = comentario;
		this.dataDePublicacao = dataDePublicacao;
	}
	public Comentarios() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario=usuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	

}
