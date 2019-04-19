package pack.thesis.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thesis")
public class Thesis {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thesis_title", nullable = false, unique = true)
    private String thesisTitle;

    @Column(name = "thesis_pdf" /*, nullable = false*/)
    private byte[] thesisPdf;

    @OneToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

    @ManyToOne
    @JoinColumn(name = "thesis_type_id", nullable = false)
    private ThesisType thesisType;

    @ManyToOne
    @JoinColumn(name = "science_code_id", nullable = false)
    private ScienceCode scienceCode;
}
