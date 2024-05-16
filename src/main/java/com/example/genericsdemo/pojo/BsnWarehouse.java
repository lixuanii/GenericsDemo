package com.example.genericsdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 公共模块-仓库对象 bsn_warehouse
 *
 * @author Steven
 * @date 2022-06-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("bsn_warehouse")
public class BsnWarehouse extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 仓库代码
     */
    private String whCode;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 类型;0.自有仓 ，1.FBA仓 ，2.客户仓
     */
    private String type;

    /**
     * 国家id
     */
    private Long countryId;

    /**
     * 国家编码
     */
    private String countryCode;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 省/州编号
     */
    private String province;

    /**
     * 省/州名称
     */
    private String provinceName;

    /**
     * 城市
     */
    private String city;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 区县
     */
    private String county;

    /**
     * 区县名称
     */
    private String countyName;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 地址1
     */
    private String address;

    /**
     * 地址2
     */
    private String standbyAddress;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 状态;0.可用，1.废弃
     */
    private String status;

    /**
     * 总容量(托)
     */
    private Integer capacity;

    /**
     * 已用容量(托)
     */
    private Integer usedCapacity;

    /**
     * 锁定容量(托)
     */
    private Integer lockCapacity;

    /**
     * 库位可用比例
     */
    private BigDecimal availableScale;

    /**
     * 工作日列表
     */
    private String calendarTitleArr;

    /**
     * 上班时间
     */
    private LocalDateTime workShift;

    /**
     * 下班时间
     */
    private LocalDateTime closingTime;

    /**
     * 删除标志;（0 false 1 true）
     */
    private Boolean delFlag;


}
