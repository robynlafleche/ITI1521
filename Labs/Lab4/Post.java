import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {
      this.userName = userName;
      this.timeStamp =  Calendar.getInstance().getTime();
      likes = 0;
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
	     return timeStamp;
    }

    public void like(){
      likes += 1;
    }

    public  int getLikes(){
      return likes;
    }



    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }


  	public int compareTo(Post other){
  	   if 	(this.timeStamp.after(other.timeStamp)) {
         return 1;
       }
       else if (this.timeStamp.before(other.timeStamp)){
         return -1;
       }
       else {
         return 0;
       }
  	}

  	public boolean isPopular(){
  	   return (likes > 100);
  	}

}
