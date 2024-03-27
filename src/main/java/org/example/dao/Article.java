package org.example.dao;

import lombok.*;
import org.example.dao.common.CommonDAO;

import java.util.ArrayList;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article extends CommonDAO {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String episode;
    private String url;
    private Date created;
}

