package Model;

public class gamerecord {
	private Integer id;
	private String username;
	private String puzzle;
	private Long time;
	
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public gamerecord(String username, String puzzle, Long time) {
		super();
		this.username = username;
		this.puzzle = puzzle;
		this.time = time;
	}
	public gamerecord() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPuzzle() {
		return puzzle;
	}
	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}
	
	public String show() {
		return "username:"+username+"\ttime:"+time;
	}
	
	
}
