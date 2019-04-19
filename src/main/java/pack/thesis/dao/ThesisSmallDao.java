//package pack.thesis.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import pack.thesis.model.ThesisOldSmall;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//public interface ThesisSmallDao extends JpaRepository<ThesisOldSmall, Long> {
//
//    Optional<ThesisOldSmall> findById(Long id);
//
//    void deleteById(Long id);
//
//    ThesisOldSmall findByThesisTitle(String thesisTitle);
//
//    List<ThesisOldSmall> findByAspirantFio(String fio);
//
//    List<ThesisOldSmall> findBySupervisorFio(String fio);
//
//    List<ThesisOldSmall> findByScienceCode(String scienceCode);
//
//    List<ThesisOldSmall> findByScienceField(String scienceField);
//
//    List<ThesisOldSmall> findByDissDefTime(Date date);
//}
//
