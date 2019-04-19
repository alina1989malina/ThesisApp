package pack.thesis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pack.thesis.dto.ScienceFieldCodeDto;
import pack.thesis.model.ScienceCode;

import java.util.List;

public interface ScienceCodeDao extends JpaRepository<ScienceCode, Long> {
    @Query("SELECT new pack.thesis.dto.ScienceFieldCodeDto(sf.title, sc.code, sc.title) "
            + "FROM ScienceCode sc LEFT JOIN sc.scienceField sf")
    List<ScienceFieldCodeDto> fetchScienceCodeScienceFieldDataLeftJoin();
}
