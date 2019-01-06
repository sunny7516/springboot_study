package com.example.demo2;

import java.time.LocalDateTime;
import java.util.Map;

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
	
	
	
	
	
	
	
	
	
	
	

/*
    // CRUD
	    
	// 1. create
    @GetMapping("/")
    public void create(){
        jdbcTemplate.execute("CREATE DATABASE POST");
    }
	// 2. read
    @GetMapping("/")
    public List<Map<String, Object>> read(){
        jdbcTemplate.execute("SHOW DATABASES");
        return jdbcTemplate.queryForList("SHOW DATABASE", 0);
    }
	// 3. update
    @GetMapping("/")
    public void update(){
        jdbcTemplate.execute("USE POST");
    }
    // 4. delete
    @GetMapping("/")
    public void delete(){
        jdbcTemplate.execute("DROP DATABASE POST");
    }
    
    // DATA

    // 1. SELECT
	@GetMapping("/")
	public String select(){
	    jdbcTemplate.update("SELECT * FROM POST");
	    return jdbcTemplate.queryForObject("select * from post", String.class);
	}
	// 2. INSERT
	@GetMapping("/")
	public long insert(){
	    jdbcTemplate.update("INSERT INTO POST (TITLE, CONTENT, CREATED_BY, CREATED_AT, LAST_MODIFIED_AT) VALUES (?,?,?,?,?)", "title", "contents", "Hong son a", LocalDateTime.now(), LocalDateTime.now());
	    return jdbcTemplate.queryForObject("select count(*) from POST", Long.class);
	}
    // 3. UPDATE
	@PostMapping("/")
	public long updateData(){
		jdbcTemplate.update("UPDATE POST SET LAST_MODIFIED_AT VALUES ?", LocalDateTime.now());
	    return jdbcTemplate.queryForObject("select count(*) from POST", Long.class);
	}
	// 4. DELETE
	@DeleteMapping("/")
	public long deleteData(){
		jdbcTemplate.update("DELETE FROM POST");
	    return jdbcTemplate.queryForObject("select count(*) from POST", Long.class);
	}*/
}
