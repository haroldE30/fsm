package org.harold.fsm.service.impl;

import org.harold.fsm.dao.CommuteDao;
import org.harold.fsm.dao.impl.CommuteDaoImpl;
import org.harold.fsm.model.Commute;
import org.harold.fsm.service.CommuteService;

public class CommuteServiceImpl implements CommuteService {
	
	private CommuteDao commuteDao;
	
	public CommuteServiceImpl(){
		setCommuteDao(new CommuteDaoImpl());
	}

	@Override
	public void persist(Commute commute){
		commuteDao.persist(commute);
	}

	public void setCommuteDao(CommuteDao commuteDao){
		this.commuteDao = commuteDao;
	}
}
