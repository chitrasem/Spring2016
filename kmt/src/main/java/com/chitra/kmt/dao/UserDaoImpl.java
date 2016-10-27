package com.chitra.kmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chitra.kmt.model.User;
 

 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

	public void save(User user) {
		 persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria crit = createEntityCriteria();
		 //Criteria crit = getSession().createCriteria(User.class);
		
		return (List<User>) crit.list();
	}

	public void deleteUserById(int id) {

		Query query = getSession().createQuery(
				"delete from Employee where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}
 
     
}
