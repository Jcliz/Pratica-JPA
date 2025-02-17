package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> dao = new DAO<>();

        Aluno aluno = new Aluno(123L, "João");
        AlunoBolsista aluno2 = new AlunoBolsista(345L, "Julia", 1000);

        dao.incluir(aluno);
        dao.incluir(aluno2);

        dao.fechar();
    }
}
