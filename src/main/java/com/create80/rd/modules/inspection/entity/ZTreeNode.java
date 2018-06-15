package com.create80.rd.modules.inspection.entity;

import java.io.Serializable;

public class ZTreeNode implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String pId;
  private String name;
  private boolean open;
  private boolean checked;

  public ZTreeNode(String id, String pid, String name, boolean open, boolean checked) {
    this.id = id;
    this.pId = pid;
    this.name = name;
    this.open = open;
    this.checked = checked;
  }

  public ZTreeNode() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getpId() {
    return pId;
  }

  public void setpId(String pId) {
    this.pId = pId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  @Override
  public String toString() {
    return "ZTreeNode{" +
        "id='" + id + '\'' +
        ", pid='" + pId + '\'' +
        ", name='" + name + '\'' +
        ", open=" + open +
        ", checked=" + checked +
        '}';
  }
}
