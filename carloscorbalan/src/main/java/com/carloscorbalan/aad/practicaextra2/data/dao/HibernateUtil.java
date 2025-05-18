package com.carloscorbalan.aad.practicaextra2.data.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.carloscorbalan.aad.practicaextra2.data.pojos.*;

import jakarta.persistence.EntityGraph;
import main.InfoUsuarios;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session currentSession = null;
	
	
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) config file.
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Dispositivos.class);
			configuration.addAnnotatedClass(Logs.class);
			configuration.addAnnotatedClass(Redes.class);
			configuration.addAnnotatedClass(TipoDispositivo.class);
			configuration.addAnnotatedClass(Usuarios.class);
			configuration.addAnnotatedClass(InfoUsuarios.class);
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			} catch (HibernateException ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
	}
	
	public static Session getSession() {
		if(currentSession == null) {
			currentSession = sessionFactory.openSession();
		} else {
			if(!currentSession.isOpen()) {
				currentSession = sessionFactory.openSession();
			}
		}
		
		return currentSession;
	}
}
