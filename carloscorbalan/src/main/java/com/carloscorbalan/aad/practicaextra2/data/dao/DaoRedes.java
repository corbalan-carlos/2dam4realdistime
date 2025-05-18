package com.carloscorbalan.aad.practicaextra2.data.dao;

import org.hibernate.Session;

import com.carloscorbalan.aad.practicaextra2.data.pojos.Redes;

public class DaoRedes  extends HibernateDao<Redes,Integer>{

	public DaoRedes() {
		super(Redes.class);
		// TODO Auto-generated constructor stub
	}

}
