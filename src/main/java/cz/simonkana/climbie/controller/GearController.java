package cz.simonkana.climbie.controller;

import cz.simonkana.climbie.dto.GearRequest;
import cz.simonkana.climbie.dto.GearResponse;
import cz.simonkana.climbie.service.GearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gear")
@RequiredArgsConstructor
public class GearController {

    private final GearService service;

    @PostMapping
    public GearResponse create(@Valid @RequestBody GearRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<GearResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GearResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public GearResponse update(@PathVariable Long id,
                               @Valid @RequestBody GearRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
