import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    // Teste para criação de um produto com dados válidos
    @Test
    public void testCriacaoProdutoComDadosValidos() {
        Produto produto = new Produto("001", "Caneta", 10, 2.5);

        assertEquals("001", produto.getCodigo());
        assertEquals("Caneta", produto.getNome());
        assertEquals(10, produto.getQuantidade());
        assertEquals(2.5, produto.getPreco());
    }

    // Teste para verificar exceção ao criar um produto com preço negativo
    @Test
    public void testPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("002", "Lápis", 10, -1.5);
        });
    }

    // Teste para verificar exceção ao criar um produto com quantidade negativa
    @Test
    public void testQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("003", "Borracha", -5, 1.0);
        });
    }

    // Teste para atualizar a quantidade de um produto
    @Test
    public void testAtualizarQuantidade() {
        Produto produto = new Produto("004", "Apontador", 5, 1.2);
        produto.setQuantidade(10);
        assertEquals(10, produto.getQuantidade());
    }
}
