package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
