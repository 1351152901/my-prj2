package com.iteasyup.myprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.iteasyup.myprj.dao.entity.BookEntity;

@Repository
public interface BookDao {
    
	/*
	 * 查询出书籍信息
	 */
	@Select("select id,book_name bookName,to_char(publishtime,'yyyy-mm-dd') publishtime  from book")
	List<BookEntity> searchBook();
	
	/*
	 * 添加书籍信息
	 */
	@Insert("insert into book values(seq_book_id.nextval,#{bookName},to_date(#{publishTime},'yyyy/mm/dd')")
	int addBook(BookEntity bookEntity); 
	
	/*
	 * 通过id修改表中书的信息
	 */
	@Update("update book set bookName = #{bookName},publishTime = to_date(#{publishTime}, 'yyyy-mm-dd') where id = #{id}")
	int modifyBookById(BookEntity bookEntity);
	
	/*
	 * 通过id删除表中书的信息
	 */
	@Delete("delete from book where id = #{value}")
	int deleteBookById(int id);
	
	/*
	 * 模糊查询
	 */
	@Select("select id id,bookName bookName,to_char(publishTime, 'yyyy-mm-dd') publishTime	from book where bookName like #{value}")
	List<BookEntity> selectByName(String name);
	
}
