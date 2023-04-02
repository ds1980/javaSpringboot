package com.in.cafe.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@SuppressWarnings("rawtypes")
public class GenericDaoImpl implements GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> createSQLQuery(String query, Map<String, Object> var) {
		Query q = null;
		q = entityManager.createNativeQuery(query);
		setQueryMap(q, var);
		return q != null ? q.getResultList() : null;
	}
	private void setQueryMap(Query q, Map<String, Object> var) {
		if (var != null) {
			Set<String> varnames = var.keySet();
			for (String key : varnames) {
				Object val = var.get(key);
				if (val instanceof String) {
					q.setParameter(key, val.toString());
				} else if (val instanceof Integer) {
					q.setParameter(key, val);
				} else if (val instanceof Date) {
					q.setParameter(key, val);
				} else if (val instanceof Long) {
					q.setParameter(key, val);
				} else if (val instanceof Object[]) {
					q.setParameter(key, (Object[]) val);
				} else if (val instanceof Collection) {
					q.setParameter(key, (Collection) val);
				} else if (val instanceof Double) {
					q.setParameter(key, (Double) val);
				} else if (val instanceof BigDecimal) {
					q.setParameter(key, (BigDecimal) val);
				}
			}
		}
	}


}
