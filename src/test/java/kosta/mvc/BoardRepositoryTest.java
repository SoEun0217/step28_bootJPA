package kosta.mvc;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import kosta.mvc.domain.Board;
import kosta.mvc.repository.BoardRepository;

@SpringBootTest
@Transactional
@Commit//dml작업에 필수
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository rep;
	
	/**
	 * 등록하기
	 * */
//	@Test
//	public void insert() {
//		for(int i=0;i<=200;i++) {
//			rep.save(new Board(null, "제목"+i, "user"+i, "Spring JPA"+i, null));
//		}
//	}
	
	@Test
	public void selectOne() {
		System.out.println(rep.findById(3L));
	}
	
	@Test
	public void deleteOne() {
		rep.deleteById(5L);
	}
	
	@Test
	public void update() {
		rep.saveAndFlush(new Board(3L,"수정되니","dkslsl","qkqn",null));
	}
	
	@Test
	public void updateSome() {
		for(int i=0;i<10;i++) {
			rep.saveAndFlush(new Board((long)i,"dd","dd","dd",null));
		}
	}
	
	@Test
	public void deleteSome() {
		for(int i=10;i<20;i++) {
			rep.deleteById((long)i);
		}
	}
	
	/**
	 * 전체검색
	 * */
	@Test
	public void selectAll() {
		List<Board>list = rep.findAll();
//		for(Board b:list) {
//			System.out.println(b);
//		}
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * 조건검색(pk대상)
	 * */
	@Test
	public void selectByno() {
		//Optional은 null여부를 체크하지 않아도 되도록,,관련메소드를 제공하는것
		//자주 발생하는 NullPointerException 때문에 만들어진 문법이다.
		Optional<Board> op = rep.findById(11L);
		Board board = op.orElse(null);//존재하지않을 때 대체할 값을 넣어준다.
		System.out.println(board);
	}
	
	
}
