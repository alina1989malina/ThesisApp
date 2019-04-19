package pack.thesis.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "science_codes")
public class ScienceCode {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "science_field_id")
    private ScienceField scienceField;

    @OneToMany(mappedBy = "scienceCode", cascade = CascadeType.ALL)
    private Collection<Thesis> theses;
}
