package com.draic.homework.controller;

import com.draic.homework.common.Result;
import com.draic.homework.pojo.bo.TransactionBo;
import com.draic.homework.pojo.command.TransactionCreateCmd;
import com.draic.homework.pojo.command.TransactionUpdateAmountCmd;
import com.draic.homework.pojo.command.TransactionUpdateDescriptionCmd;
import com.draic.homework.pojo.common.ByIdCmd;
import com.draic.homework.pojo.common.LastIdPageSizeQuery;
import com.draic.homework.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bkn1991
 * @date 2025/5/24 12:02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {

  private final TransactionService transactionService;

  /************* 增  *************/

  /** 交易新增 */
  @PostMapping("/create")
  public Result<TransactionBo> create(
      @RequestBody @Validated TransactionCreateCmd transactionCreateCmd) throws Exception {

    TransactionBo transactionBo = transactionService.create(transactionCreateCmd);

    return Result.success("交易成功", transactionBo);
  }

  /************* 删  *************/

  /** 按id删除交易 */
  @PostMapping("/deleteById")
  public Result deleteById(@RequestBody @Validated ByIdCmd byIdCmd) throws Exception {
    transactionService.deleteById(byIdCmd.getId());
    return Result.success("删除成功");
  }

  /************* 改  *************/

  @PostMapping("/updateAmount")
  public Result<TransactionBo> updateAmount(
      @RequestBody TransactionUpdateAmountCmd transactionUpdateAmountCmd) throws Exception {

    TransactionBo transactionBo = transactionService.updateAmount(transactionUpdateAmountCmd);
    return Result.success("修改成功", transactionBo);
  }

  @PostMapping("/updateDescription")
  public Result<TransactionBo> updateDescription(
      @RequestBody @Validated TransactionUpdateDescriptionCmd transactionDeleteDescriptionCmd)
      throws Exception {

    TransactionBo transactionBo =
        transactionService.updateDescription(transactionDeleteDescriptionCmd);
    return Result.success("修改成功", transactionBo);
  }

  /************* 查  *************/

  @PostMapping("/findAll")
  public Result<List<TransactionBo>> findAll(@RequestBody @Validated LastIdPageSizeQuery lastIdPageSizeQuery)
      throws Exception {
    List<TransactionBo> transactionBoList = transactionService.findAll(lastIdPageSizeQuery);
    return Result.success("查询成功", transactionBoList);
  }
}
