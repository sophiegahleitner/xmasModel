package im430.xmas.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.AddressDAO;
import im430.xmas.dao.ChildDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
@Transactional
public class ChildDAOTest {

    @Autowired
    private ChildDAO childDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Test
    public void shouldAddAddressToChild() {

        Address address = new Address();
        address.setText("Test Address1");
        addressDAO.saveOrUpdate(address);

        Child child1 = new Child();
        child1.setName("Test Hackl");
        child1.setAddress(address);

        childDAO.saveOrUpdate(child1);
        Child child2 = childDAO.getById(child1.getId());

        assertEquals(child1.getAddress(), child2.getAddress());
    }

    @Test
    public void shouldAddGiftsToChild() {

        Address address = new Address();
        address.setText("Test Address1");
        addressDAO.saveOrUpdate(address);

        Child child1 = new Child();
        child1.setName("Test Hackl");
        child1.setAddress(address);

        childDAO.saveOrUpdate(child1);

        int giftSize = child1.getGifts().size();

        Gift gift1 = new Gift();
        gift1.setDescription("Staubsauger");
        Gift gift2 = new Gift();
        gift2.setDescription("Nüsse");

        child1.addGift(gift1);
        child1.addGift(gift2);
        childDAO.saveOrUpdate(child1);

        assertEquals(child1.getGifts().size(), giftSize + 2);
    }
}
