package com.carloscorbalan.aad.practicaextra2.data.dao;

import com.carloscorbalan.aad.practicaextra2.data.pojos.Usuarios;

public class DaoUsuarios extends HibernateDao<Usuarios,Integer> {
	public DaoUsuarios() {
		super(Usuarios.class);
	}

}
