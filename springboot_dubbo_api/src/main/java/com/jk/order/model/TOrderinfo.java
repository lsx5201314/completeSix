package com.jk.order.model;

public class TOrderinfo {

  private String orderinfoid;
  private String orderinfooid;
  private String orderinfopid;
  private double orderinfocprice;
  private String number;
  private double allprice;

  public String getOrderinfoid() {
    return orderinfoid;
  }

  public void setOrderinfoid( String orderinfoid ) {
    this.orderinfoid = orderinfoid;
  }

  public String getOrderinfooid() {
    return orderinfooid;
  }

  public void setOrderinfooid( String orderinfooid ) {
    this.orderinfooid = orderinfooid;
  }

  public String getOrderinfopid() {
    return orderinfopid;
  }

  public void setOrderinfopid( String orderinfopid ) {
    this.orderinfopid = orderinfopid;
  }

  public double getOrderinfocprice() {
    return orderinfocprice;
  }

  public void setOrderinfocprice( double orderinfocprice ) {
    this.orderinfocprice = orderinfocprice;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber( String number ) {
    this.number = number;
  }

  public double getAllprice() {
    return allprice;
  }

  public void setAllprice( double allprice ) {
    this.allprice = allprice;
  }
}
