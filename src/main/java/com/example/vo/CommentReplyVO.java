package com.example.vo;


import lombok.Data;


import java.io.Serializable;
import java.util.List;

@Data
//@ApiModel(value = "CommentReply对象",description = "")
public class CommentReplyVO implements Serializable {

    //"评论ID"
    private Long commentId;

    //"评论的用户的ID"
    private Long userId;

    //"评论人的头像"
    private String portrait;

    //"评论人的昵称"
    private String nickname;

    //"评论的时间"
    private String commentTime;

    //"评论的内容"
    private String commentContent;

    //"是否显示输入框"
    private boolean inputShow;

    //"回复"
    private List<ReplyVO> reply;

}
