package com.exe.wenda.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class User_Info {
  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private int id;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private int userId;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private String userName;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private String gender;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private String imageUrl;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private Date birthDate;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private String nickname;

  @Setter(value = AccessLevel.PUBLIC)
  @Getter(value = AccessLevel.PUBLIC)
  private String eduBackground;
}
