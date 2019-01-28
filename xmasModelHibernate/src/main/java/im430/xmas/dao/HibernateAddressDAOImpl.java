package im430.xmas.dao;

import im430.xmas.business.Address;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateAddressDAOImpl extends GenericHibernateDAOImpl<Address>
	implements AddressDAO {

		public HibernateAddressDAOImpl() {
			super(Address.class);
		}
}
