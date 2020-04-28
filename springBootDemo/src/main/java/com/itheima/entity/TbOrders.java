package com.itheima.entity;

public class TbOrders {
    private Integer id;
    private String number;
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TbOrders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
