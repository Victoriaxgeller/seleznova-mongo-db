package org.example.dao;

import lombok.*;
import org.example.dao.common.CommonDAO;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post extends CommonDAO {
    private String id;
    private String title;
    private String user;
    private String content;
    private List<String> tags;
    private List<Integer> numbers;
    private int view;
    private boolean enable;


}