public interface Storage {

  String load() throws Exception;

  void save(String s) throws Exception;

}
