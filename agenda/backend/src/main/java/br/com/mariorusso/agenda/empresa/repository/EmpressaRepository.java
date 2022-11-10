package br.com.mariorusso.agenda.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mariorusso.agenda.empresa.entity.EmpressaEntity;

public interface EmpressaRepository extends JpaRepository<EmpressaEntity, Long> {

}
