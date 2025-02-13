package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {
        Filme filmeA = new Filme("Pulp Fiction", 9.2);
        Filme filmeB = new Filme("Star Wars Ep.2", 8.1);

        Ator atorA = new Ator("Samuel Jackson");
        Ator atorB = new Ator("John Travolta");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atorB);
        filmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<>();
        dao.incluirAtomico(filmeA);
    }
}
