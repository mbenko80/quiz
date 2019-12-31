package com.yegor256.quiz;

import java.io.IOException;

public interface ModifyableContent extends Content {

  void set(String newContent) throws IOException;

}
