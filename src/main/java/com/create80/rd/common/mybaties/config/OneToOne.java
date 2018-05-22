/**
 * Copyright ${license.git.copyrightYears} the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.create80.rd.common.mybaties.config;

public class OneToOne {

  private String mappingTable;
  private String column;
  private String joinColumn;
  private String javaField;
  private String where;
  private boolean noJoinField;

  public OneToOne(String mappingTable, String column, String joinColumn,String javaField) {
    super();
    this.mappingTable = mappingTable;
    this.column = column;
    this.joinColumn = joinColumn;
    this.javaField=javaField;
  }

  public boolean isNoJoinField() {
    return noJoinField;
  }

  public void setNoJoinField(boolean noJoinField) {
    this.noJoinField = noJoinField;
  }

  public String getMappingTable() {
    return mappingTable;
  }

  public void setMappingTable(String mappingTable) {
    this.mappingTable = mappingTable;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getJoinColumn() {
    return joinColumn;
  }

  public void setJoinColumn(String joinColumn) {
    this.joinColumn = joinColumn;
  }

  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  public String getJavaField() {
    return javaField;
  }

  public void setJavaField(String javaField) {
    this.javaField = javaField;
  }

  @Override
  public String toString() {
    return "OneToOne{" +
        "mappingTable='" + mappingTable + '\'' +
        ", column='" + column + '\'' +
        ", joinColumn='" + joinColumn + '\'' +
        ", javaField='" + javaField + '\'' +
        ", where='" + where + '\'' +
        '}';
  }
}
