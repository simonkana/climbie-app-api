package cz.simonkana.climbie.dto;

import cz.simonkana.climbie.model.GearType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GearResponse {

    private Long id;
    private String name;
    private GearType type;
    private String brand;
    private LocalDate purchaseDate;
    private LocalDate lastInspectionDate;
    private String status;
    private String location;
    private String notes;
}
