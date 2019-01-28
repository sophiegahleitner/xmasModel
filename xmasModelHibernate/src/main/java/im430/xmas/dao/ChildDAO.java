package im430.xmas.dao;

import im430.xmas.business.Child;

import java.util.List;

public interface ChildDAO {

    public void saveOrUpdate(Child entity);
    public Child getById(int id);
    public List<Child> getAll();
    public void delete(Child entity);
}
