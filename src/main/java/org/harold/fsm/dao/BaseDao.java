package org.harold.fsm.dao;

public interface BaseDao {
	Object save(Object object);
	void persist(Object object);
    void update(Object object);
    void delete(Object object);
	Object find(@SuppressWarnings("rawtypes") Class clazz, Long id);
}
