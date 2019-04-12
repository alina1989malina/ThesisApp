package pack.thesis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.thesis.model.Thesis;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ThesisDao extends JpaRepository<Thesis, Long> {

    Optional<Thesis> findById(Long id);

    void deleteById(Long id);

    Thesis findByThesisTitle(String thesisTitle);

    List<Thesis> findByAspirantFio(String fio);

    List<Thesis> findBySupervisorFio(String fio);

    List<Thesis> findByScienceCode(String scienceCode);

    List<Thesis> findByScienceField(String scienceField);

    List<Thesis> findByDissDefTime(Date date);
}

