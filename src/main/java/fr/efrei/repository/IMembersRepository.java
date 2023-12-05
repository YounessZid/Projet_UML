package fr.efrei.repository;

import fr.efrei.domain.Members;
import java.util.*;

public interface IMembersRepository extends IRepository<Members, Integer> {
    public List<Members> getAll();
}
