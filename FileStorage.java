import java.nio.file.Files;
import java.nio.file.Path;

public class FileStorage implements Storage {

  private final Path path;

  public FileStorage(Path path) {
    this.path = path;
  }

  @Override
  public String load() throws Exception {
    return Files.readString(path);
  }

  @Override
  public void save(String s) throws Exception {
    Files.writeString(path, s);
  }

}
