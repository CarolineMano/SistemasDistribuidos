package uam.entities;

//import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;	
	private int quantidade;
	private float valor;
	
//	@Embedded
//	private Endereco endereço;

	public Produto() {
	}

	public Produto(Long id, String nome, int quantidade, float valorUnitario) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valorUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorUnitario() {
		return valor;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valor = valorUnitario;
	}
}
