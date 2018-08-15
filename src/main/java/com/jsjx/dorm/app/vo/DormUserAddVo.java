package com.jsjx.dorm.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import com.jsjx.dorm.baseutils.BaseVo;


@ApiModel(value = "")
public class DormUserAddVo extends BaseVo {

    /**
     * 用户ID，使用UUID
     */
    @ApiModelProperty(value = "用户ID，使用UUID")
    private String userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String memo;
    /**
     * 公司代码
     */
    @ApiModelProperty(value = "公司代码")
    private String companyCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
