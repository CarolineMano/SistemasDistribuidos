package uam.dto.produto;

//import uam.dto.endereco.EnderecoDTO;

public class RegistroProdutoDTO {
	
	private String nome;
//	private EnderecoDTO endereco;
	private int quantidade;
	private float valorUnitario;
	
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
