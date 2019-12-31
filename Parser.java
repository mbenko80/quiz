import java.io.File;

public class Parser {

  private final Storage plainStorage;
  private final Storage unicodeCharacterRemovingStorage;

  public Parser(File file) {
    this.plainStorage = new FileStorage(file.toPath());
    this.unicodeCharacterRemovingStorage = new UnicodeCharacterRemovingStorage(this.plainStorage);
  }

  public String getContent() throws Exception {
    return plainStorage.load();
  }

  public String getContentWithoutUnicode() throws Exception {
    return unicodeCharacterRemovingStorage.load();
  }

  public void setContent(String content) throws Exception {
    plainStorage.save(content);
  }

}
