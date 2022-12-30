public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
      elems = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public void put(String key, Integer value) {
      if (key == null || value == null) {
        throw new NullPointerException("key or value is null");
      }
      else {
        Pair save = new Pair(key, value);
        elems[count++] = save;
        if (elems.length == count) {
          Pair[] temp = new Pair [count + INCREMENT];
          for (int i = count - 1; i >= 0; i--) {
            temp[i] = elems[i];
          }
        elems = temp;
        }
      }
    }

    private void increaseCapacity() {
      /* Your code here.  Use this in put() where necessary. */
    }

    @Override
    public boolean contains(String key) {
      if (key == null) {
        throw new NullPointerException("key or value is null");
      }
      else {
        for (int i = count - 1; i >= 0; i--) {
          if (elems[i].getKey().equals(key)) {
            return true;
          }
        }
      return false;
      }
    }

    @Override
    public Integer get(String key) {
      if (key == null) {
        throw new NullPointerException("key or value is null");
      }
      if (contains(key) == false) {
        throw new java.util.NoSuchElementException("key does not exist in Dictionary");
      }
      else {
        Integer res = 0;
        for (int i = count - 1; i >= 0; i--) {
          if (elems[i].getKey().equals(key)) {
            res = elems[i].getValue();
            break;
          }
        }
        return res;
      }
    }


    @Override
    public void replace(String key, Integer value) {
      if (key == null || value == null) {
        throw new NullPointerException("key or value is null");
      }
      if (contains(key) == false) {
        throw new java.util.NoSuchElementException("key does not exist in Dictionary");
      }
      else {
        for (int i = count - 1; i >= 0; i--) {
          if (elems[i].getKey().equals(key)) {
            elems[i].setValue(value);
          }
        }
      }
    }

    @Override
    public Integer remove(String key) {
      if (key == null) {
        throw new NullPointerException("key is null");
      }
      if (contains(key) == false) {
        throw new java.util.NoSuchElementException("key does not exist in Dictionary");
      }
      else {
        Integer saved = 0;
        for (int i = count - 1; i >= 0; i--) {
          if (elems[i].getKey().equals(key)) {
            saved = elems[i].getValue();
            elems[i] = null;
            count--;
            break;
          }
        }
        if(elems.length - count > 0 && count != 0){
          Pair[] temp = new Pair[count];
          for(int y = 0; y < count; y++){
            temp[y] = elems[y];
          }
          elems = temp;
        }
        return saved;
      }
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}
