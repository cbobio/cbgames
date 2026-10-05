package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.enums.AcaoLog;
import br.com.cbobio.cbgames.persistence.entity.TbLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<TbLog, Long> {


}