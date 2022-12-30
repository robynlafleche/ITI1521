/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	this.messages = new Post [MAX_SIZE];
    }

    public void add(Post message) {
      if (size < MAX_SIZE){
        this.messages[size] = message;
        size += 1;
      }

    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		NewsFeed photoPostOnly = new NewsFeed ();
      for (int i = 0; i < size; i++){
        if (messages [i].getClass().getName().equals("PhotoPost")){
          photoPostOnly.add(messages [i]);
        }
      }
      return photoPostOnly;
  	}

  	public NewsFeed plus(NewsFeed other){
      NewsFeed combinedFeeds = new NewsFeed ();
      for (int i = 0; i < this.size; i++){
        combinedFeeds.add (this.messages [i]);
      }
      for (int j = 0; j < other.size; j++){
        combinedFeeds.add (other.messages [j]);
      }
      combinedFeeds.sort ();
      return combinedFeeds;
  	}

}
