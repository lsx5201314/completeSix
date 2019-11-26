package com.jk.order.model;


import java.io.Serializable;

import java.util.Date;


public class TOrder implements Serializable {

  private static final long serialVersionUID = -2426513739158628490L;
  private String orderid;
  private String payment;
  private String paytype;
  private long status;
  private Date createtime;
  private long userid;
  private String username;
  private String recarea;
  private String recphone;
  private String receiver;

  public String getOrderid() {
    return orderid;
  }

  public void setOrderid( String orderid ) {
    this.orderid = orderid;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment( String payment ) {
    this.payment = payment;
  }

  public String getPaytype() {
    return paytype;
  }

  public void setPaytype( String paytype ) {
    this.paytype = paytype;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus( long status ) {
    this.status = status;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime( Date createtime ) {
    this.createtime = createtime;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid( long userid ) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername( String username ) {
    this.username = username;
  }

  public String getRecarea() {
    return recarea;
  }

  public void setRecarea( String recarea ) {
    this.recarea = recarea;
  }

  public String getRecphone() {
    return recphone;
  }

  public void setRecphone( String recphone ) {
    this.recphone = recphone;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver( String receiver ) {
    this.receiver = receiver;
  }
}
