package com.example.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReplyVO implements Serializable {

    //("回复的id")
    private Long replyId;
    private Long replyUserId;

    //("回复人的头像")
    private String portrait;

    //("回复人的昵称")
    private String nickname;

    //("回复的时间")
    private String replyTime;

    //("回复对象的ID")
    private Long replyToUserId;

    //"回复对象的昵称")
    private String replyToNickname;
    /**
     * 回复对应的评论的ID
     */
    private Long commentId;

    //("回复的内容")
    private String replyContent;

    //("是否显示输入框")
    private boolean inputShow;


}
