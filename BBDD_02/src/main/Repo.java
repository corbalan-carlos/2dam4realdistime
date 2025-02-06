package main;

public interface Repo {
	boolean create(DAO dao);
	boolean read(DAO dao);
	boolean update(DAO dao);
	boolean delete(DAO dao);
}
