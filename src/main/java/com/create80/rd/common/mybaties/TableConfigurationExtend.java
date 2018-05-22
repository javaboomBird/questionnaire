package com.create80.rd.common.mybaties;

import com.create80.rd.common.mybaties.config.OneToMany;
import com.create80.rd.common.mybaties.config.OneToOne;
import com.create80.rd.common.mybaties.config.OneToMany;
import com.create80.rd.common.mybaties.config.OneToOne;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;

/**
 * 自定义TableConfiguration
 *
 * @author yzx
 */
public class TableConfigurationExtend extends TableConfiguration {

  //表中1对应1关系
  protected List<OneToOne> oneToOneList = new ArrayList<OneToOne>();
  //表中1对多关系
  protected List<OneToMany> oneToManyList = new ArrayList<OneToMany>();

  //不生成代码
  protected boolean stopGenerator;


  public TableConfigurationExtend(Context context) {
    super(context);
  }

  public TableConfigurationExtend(String tableName, String domainName, boolean stopGenerator,
      Context context) {
    super(context);
    this.setTableName(tableName);
    this.setDomainObjectName(domainName);
    this.stopGenerator = stopGenerator;
  }

  public TableConfigurationExtend(String tableName, boolean stopGenerator,
      Context context) {
    super(context);
    this.setTableName(tableName);
    this.stopGenerator = stopGenerator;
  }

  public List<OneToOne> getOneToOneList() {
    return oneToOneList;
  }

  public void setOneToOneList(List<OneToOne> oneToOneList) {
    this.oneToOneList = oneToOneList;
  }

  public List<OneToMany> getOneToManyList() {
    return oneToManyList;
  }

  public void setOneToManyList(List<OneToMany> oneToManyList) {
    this.oneToManyList = oneToManyList;
  }

  public boolean isStopGenerator() {
    return stopGenerator;
  }

  public void setStopGenerator(boolean stopGenerator) {
    this.stopGenerator = stopGenerator;
  }
}
