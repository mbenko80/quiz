public class UnicodeCharacterRemovingStorage implements Storage {

  private final Storage storage;

  public UnicodeCharacterRemovingStorage(Storage storage) {
    this.storage = storage;
  }

  @Override
  public String load() throws Exception {
    return removeUnicodeCharaceters(storage.load());
  }

  @Override
  public void save(String s) throws Exception {
    storage.save(removeUnicodeCharaceters(s));
  }

  private String removeUnicodeCharaceters(String s) {
    return s.codePoints().filter(cp -> cp < 0x80)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

}
