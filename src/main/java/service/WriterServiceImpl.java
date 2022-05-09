package service;

import mapper.WriterMapper;
import domain.WriterVO;

public class WriterServiceImpl implements WriterService{

	@Override
	public void insert(String title, String content, String writer) {
		new WriterMapper().insert(title, content, writer);
		
	}

		
}
