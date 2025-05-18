package main;

import java.util.List;

import com.carloscorbalan.aad.practicaextra2.data.dao.DaoDispositivo;
import com.carloscorbalan.aad.practicaextra2.data.pojos.Dispositivos;
import com.carloscorbalan.aad.practicaextra2.data.pojos.Logs;

public class DispositivosService {
	private final DaoDispositivo dao;
	public DispositivosService() {
		dao=new DaoDispositivo();
	}
	public List<Logs> getLogsDispositivo(Integer idDispositivo) {
		Dispositivos a=dao.read(idDispositivo);
		return List.copyOf(a.getLogs());
	}
}
