package cz.simonkana.climbie.dto;

import cz.simonkana.climbie.model.GearType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GearRequest {

    @NotBlank
    private String name;

    @NotNull
    private GearType type;

    private String brand;

    private LocalDate purchaseDate;

    private LocalDate lastInspectionDate;

    @NotBlank
    private String status;

    private String location;

    private String notes;
}
