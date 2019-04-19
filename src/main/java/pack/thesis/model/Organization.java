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
@Table(name = "organizations")
public class Organization {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private Collection<Advert> adverts;
}
