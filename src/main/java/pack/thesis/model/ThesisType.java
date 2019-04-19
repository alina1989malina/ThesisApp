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
@Table(name = "thesis_types")
public class ThesisType {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thesis_type", unique = true)
    private String thesisType;

    @OneToMany(mappedBy = "thesisType", cascade = CascadeType.ALL)
    private Collection<Thesis> theses;
}
