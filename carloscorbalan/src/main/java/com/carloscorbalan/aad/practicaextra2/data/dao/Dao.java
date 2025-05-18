package com.carloscorbalan.aad.practicaextra2.data.dao;

import com.carloscorbalan.aad.practicaextra2.data.pojos.Pojo;

public interface Dao <T extends Pojo, S> {
	public void create(T model);
	public T read(S id);
	public void update(T model);
	public void delete(S id);
}