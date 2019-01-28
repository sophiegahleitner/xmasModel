package im430.xmas.dao;

import im430.xmas.business.Child;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateChildDAOImpl extends GenericHibernateDAOImpl<Child>
	implements ChildDAO {

		public HibernateChildDAOImpl() {
			super(Child.class);
		}
}
