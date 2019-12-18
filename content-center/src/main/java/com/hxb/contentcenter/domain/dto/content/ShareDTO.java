/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShareDto
 * Author:   admin
 * Date:     2019/12/11 20:37
 * Description: 扩展lei
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.contentcenter.domain.dto.content;

import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈扩展lei〉
 *
 * @author admin
 * @create 2019/12/11
 * @since 1.0.0
 */
@Data
public class ShareDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * 发布人id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    private Boolean isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 下载数
     */
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    private Boolean showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
