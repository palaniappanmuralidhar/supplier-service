package org.example.supplierservice.service;

import org.example.supplierservice.entity.Supplier;
import org.example.supplierservice.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repo;

    public List<Supplier> getAllSuppliers() {
        return repo.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return repo.findById(id);
    }

    public Supplier createSupplier(Supplier supplier) {
        // business rule: don't allow duplicate email
        repo.findByEmail(supplier.getEmail()).ifPresent(s -> {
            throw new IllegalArgumentException("Supplier with this email already exists");
        });
        return repo.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier update) {
        return repo.findById(id).map(existing -> {
            existing.setName(update.getName());
            existing.setCountry(update.getCountry());
            existing.setEmail(update.getEmail());
            return repo.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
    }

    public void deleteSupplier(Long id) {
        repo.deleteById(id);
    }
}
