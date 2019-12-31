package com.yegor256.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileContent implements ModifyableContent {

  private final Path path;

  public FileContent(Path path) {
    this.path = path;
  }

  @Override
  public String get() throws IOException {
    return Files.readString(path);
  }

  @Override
  public void set(String newContent) throws IOException {
    Files.writeString(path, newContent);
  }

}
