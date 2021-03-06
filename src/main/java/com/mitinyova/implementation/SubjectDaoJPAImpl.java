package com.mitinyova.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.mitinyova.entities.Subject;
import com.mitinyova.interfaces.SubjectsDao;

@Repository
@Transactional
public class SubjectDaoJPAImpl implements SubjectsDao {
	@PersistenceContext
	private EntityManager em;

	public Subject addSubject(Subject subject) {
		em.persist(subject);
		return subject;
	}

	public Subject getSubject(int id) {
		return em.find(Subject.class, id);
	}

	public void saveSubject(Subject subject) {
		em.merge(subject);
	}

}
