import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Parser {

  private final File file;

  public Parser(File file) {
    this.file = file;
  }

  public String getContent() throws IOException {
    return Files.readString(file.toPath());
  }

  public String getContentWithoutUnicode() throws IOException {
    return nonAsciiCharactersRemoved(getContent());
  }

  private String nonAsciiCharactersRemoved(String content) {
    return content.codePoints().filter(cp -> cp < 0x80)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  public void setContent(String content) throws IOException {
    Files.writeString(file.toPath(), content);
  }

}
