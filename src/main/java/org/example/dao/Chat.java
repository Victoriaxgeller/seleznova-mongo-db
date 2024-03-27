package org.example.dao;

import lombok.*;
import org.example.dao.common.CommonDAO;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chat extends CommonDAO {
	private String name;
	private int age;
	private double poids;
	private String moustache;
	private String[] petits;
}