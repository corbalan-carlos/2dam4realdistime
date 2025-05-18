package main;

import org.hibernate.query.Query;

import com.carloscorbalan.aad.practicaextra2.data.dao.DaoDispositivo;
import com.carloscorbalan.aad.practicaextra2.data.dao.DaoTipoDispositivos;
import com.carloscorbalan.aad.practicaextra2.data.dao.HibernateUtil;
import com.carloscorbalan.aad.practicaextra2.data.pojos.*;

public class TipoDispositivosService {
	private final DaoTipoDispositivos dao;
	public TipoDispositivosService() {
		dao=new DaoTipoDispositivos();
	}
	public TipoDispositivo getTipoDispositivoMasLogs() {
		Query<TipoDispositivo> query =HibernateUtil.getSession().createNamedQuery("masLogs", TipoDispositivo.class);
		return query.getSingleResult();
	}
}
