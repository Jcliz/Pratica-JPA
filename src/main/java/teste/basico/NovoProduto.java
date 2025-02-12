package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);

        Produto produto = new Produto("Caneta", 7.45);
        Produto produto2 = new Produto("Red Dead Redemption 2", 299.0);
        //dao.abrirT().incluir(produto).fecharT().fechar();

        //escolher um dos dois para a execução

        //dao.incluirAtomico(produto2).fechar();

        System.out.println("ID do último produto: " + produto.getId());
    }
}
