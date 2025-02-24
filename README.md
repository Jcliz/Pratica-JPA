# Sobre:
Repositório direcionado à práticas utilizando a tecnologia JPA.

## Trechos de código:
- Classe do DAO:
```java
public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
                query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
}
```

```java
public List<E> obterTodos(int qtde, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        
        return query.getResultList();
    }
```

- XML de querys:
```xml  
<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings version="2.1"
                 xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence/orm
                                     http://xmlns.jcp.org/xml/ns/persistence/orm_2_1.xsd">

    <named-query name="obterFilmesComNotaMaiorQue">
        <query>
            SELECT DISTINCT f FROM Filme f
            JOIN FETCH f.atores
            WHERE f.nota > :nota
        </query>
    </named-query>
    
    <named-native-query name="obterMediaGeralFilmes"
        result-set-mapping="NotaFilmeMap">
        <query>
            SELECT AVG(nota) AS media FROM filmes
        </query>
    </named-native-query>

    <sql-result-set-mapping name="NotaFilmeMap">
        <constructor-result target-class="modelo.consulta.NotaFilme">
            <column name="media" class="java.lang.Double"/>
        </constructor-result>
    </sql-result-set-mapping>

</entity-mappings>
```
