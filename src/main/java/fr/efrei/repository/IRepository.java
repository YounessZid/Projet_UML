package fr.efrei.repository;

public interface IRepository<T,ID> {
    public <T> void create(T t);
    public <T> void read(T t, int ID );
    public <T> void update(T t, int ID);
    public boolean delete(T t);
}