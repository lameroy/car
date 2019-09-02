package com.car.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/9/2 11:08
 * @Modified By：
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -110290962486804128L;

    private Integer userNum;
}
