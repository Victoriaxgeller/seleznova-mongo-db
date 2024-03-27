package org.example.dao.common;

import lombok.ToString;

import java.lang.reflect.Field;

public class CommonDAO {

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject.getClass() == this.getClass()) {
            Field[] fields = this.getClass().getFields();
            boolean fieldsEqual = true;
            for (Field field : fields) {
                try {
                    fieldsEqual = field.get(anObject).equals(field.get(this));
                } catch (IllegalAccessException e) {
                }
            }
            return fieldsEqual;
        }
        return false;
    }
}

