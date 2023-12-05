package fr.efrei.repository;
import java.util.*;
import fr.efrei.domain.GymAdmin;

public interface IGymAdminRepository extends IRepository<GymAdmin, Integer>{
    public List<GymAdmin> getAll();
}
