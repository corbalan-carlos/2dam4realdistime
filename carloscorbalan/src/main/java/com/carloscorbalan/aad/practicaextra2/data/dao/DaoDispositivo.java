package com.carloscorbalan.aad.practicaextra2.data.dao;

import com.carloscorbalan.aad.practicaextra2.data.pojos.Dispositivos;

public class DaoDispositivo extends HibernateDao<Dispositivos,Integer> {

	public DaoDispositivo() {
		super(Dispositivos.class);
		// TODO Auto-generated constructor stub
	}

}
