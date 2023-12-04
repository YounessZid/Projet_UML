package fr.efrei.repository;

import fr.efrei.domain.Subscription;
import java.util.*;

public interface ISubscriptionRepository extends IRepository<Subscription, Integer>{

    public List<Subscription> getAll();

}