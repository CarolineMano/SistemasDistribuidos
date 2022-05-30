package uam.dto.produto;


public class ConsultaProdutoDTO {
	
	private Long id;
	private String nome;
	private int quantidade;
	private float valorUnitario;
	
	public ConsultaProdutoDTO() {
	}

	public ConsultaProdutoDTO(Long id, String nome, int quantidade, float valorUnitario) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
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
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
