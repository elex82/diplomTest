package ru.sapteh.model;

import java.util.ArrayList;
import java.util.List;

public class Column {
    public String field;
    public String type;
    public String anull;
    public String key;
    public String defaultt;
    public String extra;
    public String length;
    List <String> valueColumn = new ArrayList<>();
    public ForinKey forinKey;

    public ForinKey getForinKey() {
        return forinKey;
    }

    public void setForinKey(ForinKey forinKey) {
        this.forinKey = forinKey;
    }

    public List<String> getValueColumn() {
        return valueColumn;
    }

    public void setValueColumn(List<String> valueColumn) {
        this.valueColumn = valueColumn;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnull() {
        return anull;
    }

    public void setAnull(String anull) {
        this.anull = anull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultt() {
        return defaultt;
    }

    public void setDefaultt(String defaultt) {
        this.defaultt = defaultt;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Column(String field, String defaultt, String anull,String type,String length,  String key,  String extra ) {
        this.field = field;
        this.type = type;
        this.anull = anull;
        this.key = key;
        this.defaultt = defaultt;
        this.extra = extra;
        this.length = length;
    }

    public Column() {

    }

}
