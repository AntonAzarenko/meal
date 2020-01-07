package com.azarenka.service.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class TodayMenuResponse {
    private String time;
    private List<MenuResponse> menuResponse;

    public TodayMenuResponse(String time, List<MenuResponse> menuResponse) {
        this.time = time;
        this.menuResponse = menuResponse;
    }

    public List<MenuResponse> getMenuResponse() {
        return menuResponse;
    }

    public void setMenuResponse(List<MenuResponse> menuResponse) {
        this.menuResponse = menuResponse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TodayMenuResponse that = (TodayMenuResponse) o;

        return new EqualsBuilder()
                .append(time, that.time)
                .append(menuResponse, that.menuResponse)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(time)
                .append(menuResponse)
                .toHashCode();
    }
}
