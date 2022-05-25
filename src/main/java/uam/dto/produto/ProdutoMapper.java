package uam.dto.produto;

//import uam.dto.endereco.EnderecoMapper;
import uam.entities.Produto;

public class ProdutoMapper {
	public static Produto fromDTO(RegistroProdutoDTO dto) {
		return new Produto(null, dto.getNome(), dto.getQuantidade(), dto.getValorUnitario());
	}
	
	public static ConsultaProdutoDTO fromEntity(Produto produto) {
		return new ConsultaProdutoDTO(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getValorUnitario());
	}
}
