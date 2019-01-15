package com.example.demo2;

import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	// db 조회
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*
	 * [GET] /post/sona
	 */
	@GetMapping("/{id}")
	public Map<String, Object> find(@PathVariable Long id) {
		// 와일드카드(*) 사용보다 조회할 컬럼값 명시하는 것이 효율적
		String selectSql = "SELECT id, title, content, created_by, created_at, last_modified_at FROM POST WHERE id=?";
		return jdbcTemplate.queryForMap(selectSql, id);
	}

	/*
	 * [POST] /post
	 */
	@PostMapping
	public Integer create(@RequestBody Map<String, Object> body) {
		String insertSql = "INSERT INTO post(title, content, created_by, created_at, last_modified_at) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(insertSql, body.get("title"), body.get("content"), body.get("created_by"), LocalDateTime.now(), LocalDateTime.now());
	}

	// 2. INSERT
	@GetMapping("/")
	public long insert(){
	    jdbcTemplate.update("INSERT INTO POST (TITLE, CONTENT, CREATED_BY, CREATED_AT, LAST_MODIFIED_AT) VALUES (?,?,?,?,?)", "title", "contents", "Hong son a", LocalDateTime.now(), LocalDateTime.now());
	    return jdbcTemplate.queryForObject("select count(*) from POST", Long.class);
	}
	
	/*
	 * [DELETE] /post
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		String deleteSql = "DELETE FROM POST WHERE ID = ?";
		jdbcTemplate.update(deleteSql, id);
	}

	/*
	 * [PUT] /post
	 */
	@PutMapping
	public Integer edit(@RequestBody Map<String, Object> body) {
		String updateSql = "UPDATE post set title = ?, content = ?, last_modified_at = ? where ID = ?";
		return jdbcTemplate.update(updateSql, body.get("title"), body.get("content"), LocalDateTime.now(), body.get("id"));
	}
}
