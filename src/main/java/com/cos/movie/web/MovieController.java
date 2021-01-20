package com.cos.movie.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.SaveReqDto;
import com.cos.movie.domain.UpdateReqDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;


@RestController
public class MovieController {
	
	private MovieRepository movieRepository;
	
	//DI(의존성 주입)
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository= movieRepository;
	}
	
	// 1. host주소 = http://localhost:8080/application/json
	//	​2. 요청과 응답
	//	요청 Type 공통 = application/json
	//	응답 Type 공통 = application/json
	
	// 3. 전체영화 가져오기
	//	GET    /movie
	//	응답 BODY 데이터 (Movie 오브젝트를 컬렉션에 담아 json으로 변환하여 응답)
	@GetMapping("/application/json/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");
		//return movieRepository.findAll();
		//MessageConverter(JavaObject를 JsonString으로)
		//기본 동작이 json
		//return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll());
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll());
		
	}
	
	// 4. 영화 1건 가져오기(숫자로 구분 = 숫자는 영화의 id값)
	//	Get    /movie/8
	//	응답 BODY 데이터 (Movie 오브젝트를 json으로 변환하여 응답)
	@GetMapping("/application/json/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) { //어노테이션
		System.out.println("findById(): id: " +id);
		//return userRepository.findById(id);
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}
	
	// 5. save 영화 등록하기
	//	POST   /movie
	//	요청 BODY 데이터 (title, rating)
	//	응답 BODY 데이터 성공시 (statusCode = 200, msg = “ok”)
	//	응답 BODY 데이터 실패시 (statusCode = 500, msg = “fail”)
	// text/plain =>@RequestBody 어노테이션 사용하면 받아짐
	// application/json => @ResponseBody 어노테이션 + 오브젝트로 받음
	@PostMapping("/application/json/movie") // 모델명만 적음 = user
	public CommonDto<String> save(@RequestBody SaveReqDto dto) {
		System.out.println("save()");
		System.out.println("user: "+dto);
		movieRepository.save(dto);
		
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
		//500번 = SERVER_ERROR
	}
	
	// ​6. 영화 삭제하기
	//	DELETE   /movie/8
	//	응답 BODY 데이터 성공시 (statusCode = 200, msg = “ok”)
	//	응답 BODY 데이터 실패시 (statusCode = 500, msg = “fail”)
	@DeleteMapping("/application/json/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
	
	// update 7. 영화  수정하기
	//	PUT    /movie/7
	//	BODY 데이터 (title, rating)
	//	응답 BODY 데이터 성공시 (statusCode = 200, msg = “ok”)
	//	응답 BODY 데이터 실패시 (statusCode = 500, msg = “fail”)
	@PutMapping("/application/json/movie/{id}")
	public CommonDto update(@PathVariable int id, @RequestBody UpdateReqDto dto) {
		System.out.println("update()");
		movieRepository.update(id, dto);
		//return new CommonDto<>(HttpStatus.OK.value(),"ok");
		try {
			return new CommonDto<>(HttpStatus.OK.value(),"ok");
		} catch (IllegalArgumentException e) {
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail");
		}
	}

}
