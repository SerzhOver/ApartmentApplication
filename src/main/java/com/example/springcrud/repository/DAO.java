package com.example.springcrud.repository;



import java.util.List;

public interface DAO<T> {

	T create(T t);

	T update(T t,int id);

	T delete(int id);

	T getByID(int id);

	List<T> getAll();
}
