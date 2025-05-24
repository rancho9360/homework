package com.draic.homework.pojo.common;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bkn1991
 * @date 2025/5/24 18:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LastIdPageSizeQuery {

  @NotNull(message = "lastId 不能为空")
  @Min(value = 0, message = "lastId 不能为负数")
  private Long lastId = 0L; // 默认值 0

  @NotNull(message = "pageSize 不能为空")
  @Min(value = 1, message = "pageSize 至少为 1")
  private Integer pageSize = 10; // 默认值 10
}
