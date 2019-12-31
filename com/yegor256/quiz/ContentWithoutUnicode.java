package com.yegor256.quiz;

import java.io.IOException;

public class ContentWithoutUnicode implements Content {

  private final Content content;

  public ContentWithoutUnicode(Content content) {
    this.content = content;
  }

  @Override
  public String get() throws IOException {
    return removeUnicode(content.get());
  }

  private static final int FIRST_UNICODE_CODEPOINT = 0x80;

  private String removeUnicode(String s) {
    return s.codePoints()
        .filter(cp -> cp < FIRST_UNICODE_CODEPOINT)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

}
