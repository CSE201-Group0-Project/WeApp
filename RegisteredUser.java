
public class RegisteredUser extends User {
	private String userName;
	private String passWord;
	
	public RegisteredUser(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public Forum createForum() {
		Forum newForum = new Forum();
		return newForum;
	}
	
	public Comment postOnForum() {
		Comment newComment = new Comment();
		return newComment;
	}
	
	public void logOut() {
		
	}

}
