package com.book.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.entity.book;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<book, Integer> {

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update bookdetails set bname = ?, publishyear = ? where bid=?")
	public void updateBk(String bname, int publishyear, int id);

//	@Query("update bookdetails u set u.bname = :a, u.publishyear = :b where u.bid= :c")
//	public void updateBk(@Param("a") String bname, @Param("b") int publishyear, @Param("c") int id);
	
}
