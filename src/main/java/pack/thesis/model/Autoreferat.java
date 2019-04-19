package pack.thesis.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "autorefs")
public class Autoreferat {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autoref_pdf" /*, nullable = false*/)
    private byte[] autorefPdf;

    @OneToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
}
