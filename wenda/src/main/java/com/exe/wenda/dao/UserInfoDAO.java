package com.exe.wenda.dao;

import com.exe.wenda.model.User_Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserInfoDAO {
  String TABLE_NAME = "user_info";
  String INSERT_FIELDS = " user_id, user_name, gender,image_url, birth_date, nickname, edu_background ";
  String SELECT_FIELDS = " id, user_id, user_name, gender,image_url, birth_date, nickname, edu_background ";

  @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
          ") values (#{user_id},#{userName},#{gender},#{imageUrl},#{birthDate},#{nickname},#{eduBackground})"})
  User_Info setUserInfo(User_Info userInfo);

  @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
  User_Info selectById(int id);

}
