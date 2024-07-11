package dao;

import java.util.ArrayList;

import entity.SuperEntity;

public interface CrudDao<T extends SuperEntity,ID> extends SuperDao {
    boolean save(T t) throws Exception;

    boolean delete(ID id) throws Exception;

    public boolean update(T t) throws Exception;

    public T get(ID id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
}
