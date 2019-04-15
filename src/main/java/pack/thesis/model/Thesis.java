package pack.thesis.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis")
public class Thesis {

//    @Id
//    @SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 205, allocationSize = 12)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
//    @Column(name = "id", nullable = false)

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thesis_title", nullable = false, unique = true)
    private String thesisTitle;

    @Column(name = "aspirant_fio", nullable = false)
    private String aspirantFio;

    @Column(name = "diss_def_time", nullable = false)
    private Date dissDefTime;

    @Column(name = "supervisor_fio", nullable = false)
    private String supervisorFio;

    @Column(name = "thesis_type", nullable = false)
    private String thesisType;

    @Column(name = "science_field", nullable = false)
    private String scienceField;

    @Column(name = "science_code", nullable = false)
    private String scienceCode;

    @Column(name = "org_title", nullable = false)
    private String organization;

    @Column(name = "pages_num", nullable = false)
    private Integer pagesNum;
}
