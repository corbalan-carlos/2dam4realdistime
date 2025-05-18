package main;

import org.hibernate.query.Query;

import com.carloscorbalan.aad.practicaextra2.data.dao.DaoRedes;
import com.carloscorbalan.aad.practicaextra2.data.dao.HibernateUtil;
import com.carloscorbalan.aad.practicaextra2.data.pojos.Redes;

public class RedesService {
	private final DaoRedes dao; 
	public RedesService() {
		dao=new DaoRedes();
	}
	public void delete(Redes toDelete) {
		if (toDelete.getDispositivos().isEmpty()) dao.delete(toDelete.getId_red());
		System.err.println("Red cuenta con dispositivos, no ha sido posible borrarla");
	}
	public boolean haUsadoRedUsuario(Integer idUsuario, Integer idRed) {
		Query<Redes> q=HibernateUtil.getSession().createNamedQuery("redUsada",Redes.class);
		q.setParameter("red", idUsuario);
		q.setParameter("u", idRed);
		if (q.getSingleResultOrNull()==null) return false;
		return true;
	}
}
