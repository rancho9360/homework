package com.draic.homework.common;

/**
 * @author bkn1991
 * @date 1/10/2023 1:44 PM
 */
public class SnowFlakeUtil {

  /** 起始的时间戳 */
  private static final long START_STMP = 1671583415981L;

  /** 每一部分占用的位数 */
  private static final long SEQUENCE_BIT = 12; // 序列号占用的位数s

  private static final long MACHINE_BIT = 5; // 机器标识占用的位数
  private static final long DATACENTER_BIT = 5; // 数据中心占用的位数

  /** 每一部分的最大值 */
  private static final long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);

  private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
  private static final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

  /** 每一部分向左的位移 */
  private static final long MACHINE_LEFT = SEQUENCE_BIT;

  private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
  private static final long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

  private long datacenterId = 1; // 数据中心
  private long machineId = 1; // 机器标识
  private long sequence = 0L; // 序列号
  private long lastStmp = -1L; // 上一次时间戳

  public SnowFlakeUtil(long datacenterId, long machineId) {
    if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
      throw new IllegalArgumentException(
          "datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
    }
    if (machineId > MAX_MACHINE_NUM || machineId < 0) {
      throw new IllegalArgumentException(
          "machineId can't be greater than MAX_MACHINE_NUM or less than 0");
    }
    this.datacenterId = datacenterId;
    this.machineId = machineId;
  }

  public SnowFlakeUtil() {}

  /**
   * 产生下一个ID
   *
   * @return
   */
  public synchronized Long nextId() {
    long currStmp = getNewstmp();
    if (currStmp < lastStmp) {
      throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
    }

    if (currStmp == lastStmp) {
      // 相同毫秒内，序列号自增
      sequence = (sequence + 1) & MAX_SEQUENCE;
      // 同一毫秒的序列数已经达到最大
      if (sequence == 0L) {
        currStmp = getNextMill();
      }
    } else {
      // 不同毫秒内，序列号置为0
      sequence = 0L;
    }

    lastStmp = currStmp;

    return Long.valueOf(
        (currStmp - START_STMP) << TIMESTMP_LEFT // 时间戳部分
            | datacenterId << DATACENTER_LEFT // 数据中心部分
            | machineId << MACHINE_LEFT // 机器标识部分
            | sequence); // 序列号部分
  }

  private long getNextMill() {
    long mill = getNewstmp();
    while (mill <= lastStmp) {
      mill = getNewstmp();
    }
    return mill;
  }

  private long getNewstmp() {
    return System.currentTimeMillis();
  }

  public static void main(String[] args) {
    SnowFlakeUtil snowFlakeUtil = new SnowFlakeUtil(1, 1);

    for (int i = 0; i < (1 << 12); i++) {
      System.out.println(snowFlakeUtil.nextId());
    }
  }
}
