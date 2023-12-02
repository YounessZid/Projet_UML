package fr.efrei.repository;

public interface IReposiitory<T,ID> {
    public <T> void create(T t);
    public <T> void read(T t);
    public <T> void update(T t);
    public boolean delete(T t);
}
