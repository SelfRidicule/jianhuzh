package com.zhongzhou.utils;

public class JsTreeBean {
    private String id;
    private String text;
    private String icon;
    private Object data;
    private State state = new State();
    private String type;
    private Object children;
    private String li_attr;
    private String a_attr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStateSelected(Boolean state) {
        State state1 = getState();
        state1.setSelected(state);
        this.state = state1;
    }

    public void setStateOpened(Boolean state) {
        State state1 = getState();
        state1.setOpened(state);
        this.state = state1;
    }
    public void setStateDisabled(Boolean state) {
        State state1 = getState();
        state1.setDisabled(state);
        this.state = state1;
    }

    public void setStateChecked(Boolean state) {
        State state1 = getState();
        state1.setChecked(state);
        this.state = state1;
    }

    public void setStateUndetermined(Boolean state) {
        State state1 = getState();
        state1.setUndetermined(state);
        this.state = state1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public String getLi_attr() {
        return li_attr;
    }

    public void setLi_attr(String li_attr) {
        this.li_attr = li_attr;
    }

    public String getA_attr() {
        return a_attr;
    }

    public void setA_attr(String a_attr) {
        this.a_attr = a_attr;
    }
}

class State{
    private Boolean selected = false;
    private Boolean opened = false;
    private Boolean disabled = false;
    private Boolean checked = false;
    private Boolean undetermined = false;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getUndetermined() {
        return undetermined;
    }

    public void setUndetermined(Boolean undetermined) {
        this.undetermined = undetermined;
    }
}
