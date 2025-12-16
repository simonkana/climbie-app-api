package cz.simonkana.climbie.service;

import cz.simonkana.climbie.dto.GearRequest;
import cz.simonkana.climbie.dto.GearResponse;
import cz.simonkana.climbie.model.Gear;
import cz.simonkana.climbie.repository.GearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GearService {

    private final GearRepository repository;

    public GearResponse create(GearRequest request) {
        Gear gear = Gear.builder()
                .name(request.getName())
                .type(request.getType())
                .brand(request.getBrand())
                .purchaseDate(request.getPurchaseDate())
                .lastInspectionDate(request.getLastInspectionDate())
                .status(request.getStatus())
                .location(request.getLocation())
                .notes(request.getNotes())
                .build();

        Gear saved = repository.save(gear);
        return toResponse(saved);
    }

    public List<GearResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public GearResponse findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Gear not found"));
    }

    public GearResponse update(Long id, GearRequest request) {
        Gear gear = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gear not found"));

        gear.setName(request.getName());
        gear.setType(request.getType());
        gear.setBrand(request.getBrand());
        gear.setPurchaseDate(request.getPurchaseDate());
        gear.setLastInspectionDate(request.getLastInspectionDate());
        gear.setStatus(request.getStatus());
        gear.setLocation(request.getLocation());
        gear.setNotes(request.getNotes());

        return toResponse(repository.save(gear));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GearResponse toResponse(Gear gear) {
        return GearResponse.builder()
                .id(gear.getId())
                .name(gear.getName())
                .type(gear.getType())
                .brand(gear.getBrand())
                .purchaseDate(gear.getPurchaseDate())
                .lastInspectionDate(gear.getLastInspectionDate())
                .status(gear.getStatus())
                .location(gear.getLocation())
                .notes(gear.getNotes())
                .build();
    }
}
