package cn.tedu.store.entity;

public class ResponseResult<T> {
	public  static final int STATE_OK=1;
	public  static final int STATE_REE=0;
	private Integer state;
	private String message;
	private T data;
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public ResponseResult() {
		super();
	}
	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}
	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	public ResponseResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	public ResponseResult(Throwable throwable){
		super();
		this.state=0;
		this.message=throwable.getMessage();
	}
	
	
}
