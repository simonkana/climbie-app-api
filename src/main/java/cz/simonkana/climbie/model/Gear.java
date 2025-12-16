package cz.simonkana.climbie.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "gear")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GearType type;

    private String brand;

    private LocalDate purchaseDate;

    private LocalDate lastInspectionDate;

    @Column(nullable = false)
    private String status;

    private String location;

    @Column(length = 2000)
    private String notes;
}
