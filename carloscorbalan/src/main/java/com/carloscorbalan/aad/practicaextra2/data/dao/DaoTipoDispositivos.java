package com.carloscorbalan.aad.practicaextra2.data.dao;

import com.carloscorbalan.aad.practicaextra2.data.pojos.TipoDispositivo;

public class DaoTipoDispositivos extends HibernateDao<TipoDispositivo,Integer>{

	public DaoTipoDispositivos() {
		super(TipoDispositivo.class);
		// TODO Auto-generated constructor stub
	}

}
