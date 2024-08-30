package iplbooking.repository;

import org.springframework.data.repository.CrudRepository;

import iplbooking.iplbooking.entity.Dummy;

public interface DummyRepository extends CrudRepository<Dummy, Integer> {
    public DummyRepository findById(int id);

    public DummyRepository findByUsesname(String username);
}
