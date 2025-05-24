package com.draic.homework.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User常规场景下的bo对象
 *
 * @author bkn1991
 * @date 2025/5/23 14:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {

  private Long id;

  private String username;

  private String name;

  private String phoneNumber;

  private String email;
}
