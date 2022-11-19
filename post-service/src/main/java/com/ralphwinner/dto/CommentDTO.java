package com.ralphwinner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDTO {
    public Long Id;
    public String commentContent;
    public int postId;
    public int userId;
    public LocalDate ins_date_time;
}
