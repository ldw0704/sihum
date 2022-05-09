package service;

import java.util.Collection;

import domain.ListInfoVO;
import domain.WriterVO;
import mapper.sListMapper;

public class sListServiceImpl implements sListService{

	@Override
	public ListInfoVO read() {
		// TODO Auto-generated method stub

		Collection<WriterVO> list =  new sListMapper().read();
		ListInfoVO listInfos = new ListInfoVO();
		listInfos.setList(list);
		
		return listInfos;
	}

	
}
