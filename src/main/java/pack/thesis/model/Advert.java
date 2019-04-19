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
@Table(name = "adverts")
public class Advert {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aspirant_fio", nullable = false)
    private String aspirantFio;

    @Column(name = "diss_def_time", nullable = false)
    private Date dissDefTime;

    @Column(name = "adv_url", nullable = false, unique = true)
    private String advUrl;

    @Column(name = "council", nullable = false)
    private String council;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @OneToOne(mappedBy = "advert", cascade = CascadeType.ALL)
    private Autoreferat autoreferat;

    @OneToOne(mappedBy = "advert", cascade = CascadeType.ALL)
    private Thesis thesis;
}