package im430.xmas.dao;

import im430.xmas.business.Address;

import java.util.List;

public interface AddressDAO {

    public void saveOrUpdate(Address entity);
    public Address getById(int id);
    public List<Address> getAll();
    public void delete(Address entity);
}
