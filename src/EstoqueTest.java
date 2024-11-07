import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("001", "Caneta", 10, 2.5);
        estoque.adicionarProduto(produto);
        assertEquals(1, estoque.getTotalProdutos());
    }

    @Test
    public void testAdicionarProdutoDuplicado() {
        Produto produto = new Produto("001", "Caneta", 10, 2.5);
        estoque.adicionarProduto(produto);
        estoque.adicionarProduto(produto); // Adiciona o mesmo produto novamente
        assertEquals(1, estoque.getTotalProdutos(), "Deve evitar produtos duplicados");
    }

    @Test
    public void testBuscarProdutoExistente() {
        Produto produto = new Produto("002", "Lápis", 20, 1.5);
        estoque.adicionarProduto(produto);

        Produto encontrado = estoque.buscarProduto("002");
        assertNotNull(encontrado, "Produto deve ser encontrado");
        assertEquals("Lápis", encontrado.getNome());
    }

    @Test
    public void testBuscarProdutoNaoExistente() {
        Produto encontrado = estoque.buscarProduto("999");
        assertNull(encontrado, "Produto não existente deve retornar null");
    }
}
