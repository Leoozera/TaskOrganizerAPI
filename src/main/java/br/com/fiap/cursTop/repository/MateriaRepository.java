package br.com.fiap.cursTop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cursTop.models.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    //criar a pesquisa personalizada (FindBy(nome do atributo) e passar um paramentro String para ele saber o que buscar no banco de dados)

}
