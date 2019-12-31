package com.yegor256.quiz;

import java.io.File;
import java.io.IOException;

public class Parser {

  private File file;

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public String getContent() throws IOException {
    return fileContent().get();
  }

  public String getContentWithoutUnicode() throws IOException {
    return new ContentWithoutUnicode(fileContent()).get();
  }

  public void saveContent(String content) throws IOException {
    fileContent().set(content);
  }

  private FileContent fileContent() {
    return new FileContent(file.toPath());
  }

}
