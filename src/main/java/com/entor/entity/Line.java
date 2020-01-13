package com.entor.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@TableName("lms_line")
public class Line implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String lineNane;

    private String start;

    private String end;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineNane() {
        return lineNane;
    }

    public void setLineNane(String lineNane) {
        this.lineNane = lineNane;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
        "id=" + id +
        ", lineNane=" + lineNane +
        ", start=" + start +
        ", end=" + end +
        "}";
    }
}
