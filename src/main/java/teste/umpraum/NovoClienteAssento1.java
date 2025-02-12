package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento a = new Assento("16C");
        Cliente c = new Cliente("João", a);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluir(a)
                .incluir(c)
                .fecharT()
                .fechar();
    }
}
