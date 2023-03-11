package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_load_file")
public class LoadFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件id
     */
    @TableId(value = "file_id", type = IdType.UUID)
    private String fileId;

    /**
     * 文件标题
     */
    private String title;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人的id
     */
    private Long userId;

    /**
     * 文件类型
     */
    private String type;


}
