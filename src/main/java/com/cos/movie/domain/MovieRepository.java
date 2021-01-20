package com.cos.movie.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
	public List<Movie> findAll(){
		List<Movie> movies= new ArrayList<>();
		movies.add(new Movie(1,"원더우먼", 10.0, "2020.12.23"));
		movies.add(new Movie(2,"아이 엠 우먼", 11.1, "2021.01.14"));
		movies.add(new Movie(3,"아이엠히어", 12.2, "2021.01.14"));
		return movies;
	}
	
	public Movie findById(int id){
		return new Movie(8,"원더우먼", 10.0, "2020.12.23");
	}
	
//	public List<Movie> findById(int id){
//		List<Movie> movies= new ArrayList<>();
//		movies.add(new Movie(1,"원더우먼", 10.0, "2020.12.23"));
//		movies.add(new Movie(2,"아이 엠 우먼", 11.1, "2021.01.14"));
//		movies.add(new Movie(3,"아이엠히어", 12.2, "2021.01.14"));
//		movies.add(new Movie(4,"화양연화", 10.0, "2020.12.23"));
//		movies.add(new Movie(5,"늑대와춤을", 11.1, "2021.01.14"));
//		movies.add(new Movie(6,"발렌타인", 12.2, "2021.01.14"));
//		movies.add(new Movie(7,"도굴", 10.0, "2020.12.23"));
//		movies.add(new Movie(8,"빛의아버지", 11.1, "2021.01.14"));
//		return movies;
//	}
	
	public void save(SaveReqDto dto) {
		System.out.println("db에 insert");
	}
	
	public void delete(int id) {
		System.out.println("db에 delete");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("db에 수정하기");
		//throw new IllegalArgumentException("(statusCode = 500, msg = “fail”)");
//		try {
//			System.out.println("db에 수정하기");
//		} catch (IllegalArgumentException e) {
//			throw new IllegalArgumentException("(statusCode = 500, msg = “fail”)");
//		}
	}

}
