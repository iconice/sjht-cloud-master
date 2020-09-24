package com.sjht.cloud.entrance.entity.extend;

import lombok.Data;
import lombok.ToString;

/**一个专用的pojo*/
@Data
@ToString
public class TempPOJO {
    /**申请主记录状态 2-待审核、3-审核不通过、4-审核通过*/
     int status;
    /**申请主记录类型  1-入学、2-转学'*/
     int type;
    /**申请户籍记录状态 2-待审核、3-审核不通过、4-审核通过*/
     int statusBase;
    /**申请房产记录状态 2-待审核、3-审核不通过、4-审核通过*/
     int statusHouse;
    /**申请疫苗记录状态 2-待审核、3-审核不通过、4-审核通过*/
     int statusPre;
    /**申请转学记录状态 2-待审核、3-审核不通过、4-审核通过*/
     int statusStu;
}
