package com.zhongzhou.utils;

import java.util.List;

public class LyingMenu {

    private String title;
    private String icon;
    private String href;
    private boolean open;
    private List<LyingMenu> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<LyingMenu> getList() {
        return list;
    }

    public void setList(List<LyingMenu> list) {
        this.list = list;
    }
}
