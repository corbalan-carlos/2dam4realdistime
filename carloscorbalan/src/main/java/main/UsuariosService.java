package main;

import java.util.List;

import org.hibernate.query.Query;

import com.carloscorbalan.aad.practicaextra2.data.dao.DaoRedes;
import com.carloscorbalan.aad.practicaextra2.data.dao.DaoUsuarios;
import com.carloscorbalan.aad.practicaextra2.data.dao.HibernateUtil;


public class UsuariosService {
	private final DaoUsuarios dao; 
	public UsuariosService() {
		dao=new DaoUsuarios();
	}
	List<InfoUsuarios> getInfoUsuarios() {
		Query<InfoUsuarios> q =HibernateUtil.getSession().createNamedQuery("infoUsuarios",InfoUsuarios.class);
		return q.list();
	}
}
