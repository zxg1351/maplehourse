package com.zxg.maplehourse.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/19.
 */
@Data
public class ResultInfo<T> implements Serializable{

    // 返回值Code ResultType 类型的参考
    private String resultCode;
    // 错误信息
    private String resultMessage;

    private T appData;
}
