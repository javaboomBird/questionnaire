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
package com.create80.rd.common.mybaties;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 自定义注释
 *
 * @author yzx
 */
public class CommentGenerator extends DefaultCommentGenerator {

  @Override
  public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    StringBuilder sb = new StringBuilder();
    method.addJavaDocLine("/**"); //$NON-NLS-1$
    sb.append(" * ");
    if (method.isConstructor()) {
      sb.append(" 构造查询条件");
    }
    String method_name = method.getName();
    if ("setOrderByClause".equals(method_name)) {
      sb.append(" 设置排序字段");
    } else if ("setDistinct".equals(method_name)) {
      sb.append(" 设置过滤重复数据");
    } else if ("getOredCriteria".equals(method_name)) {
      sb.append(" 获取当前的查询条件实例");
    } else if ("isDistinct".equals(method_name)) {
      sb.append(" 是否过滤重复数据");
    } else if ("getOrderByClause".equals(method_name)) {
      sb.append(" 获取排序字段");
    } else if ("createCriteria".equals(method_name)) {
      sb.append(" 创建一个查询条件");
    } else if ("createCriteriaInternal".equals(method_name)) {
      sb.append(" 内部构建查询条件对象");
    } else if ("clear".equals(method_name)) {
      sb.append(" 清除查询条件");
    } else if ("countByExample".equals(method_name)) {
      sb.append(" 根据指定的条件获取数据库记录数");
    } else if ("deleteByExample".equals(method_name)) {
      sb.append(" 根据指定的条件删除数据库符合条件的记录");
    } else if ("deleteByPrimaryKey".equals(method_name)) {
      sb.append(" 根据主键删除数据库的记录");
    } else if ("insert".equals(method_name)) {
      sb.append(" 新写入数据库记录");
    } else if ("insertSelective".equals(method_name)) {
      sb.append(" 动态字段,写入数据库记录");
    } else if ("selectByExample".equals(method_name)) {
      sb.append(" 根据指定的条件查询符合条件的数据库记录");
    } else if ("selectByPrimaryKey".equals(method_name)) {
      sb.append(" 根据指定主键获取一条数据库记录");
    } else if ("updateByExampleSelective".equals(method_name)) {
      sb.append(" 动态根据指定的条件来更新符合条件的数据库记录");
    } else if ("updateByExample".equals(method_name)) {
      sb.append(" 根据指定的条件来更新符合条件的数据库记录");
    } else if ("updateByPrimaryKeySelective".equals(method_name)) {
      sb.append(" 动态字段,根据主键来更新符合条件的数据库记录");
    } else if ("updateByPrimaryKey".equals(method_name)) {
      sb.append(" 根据主键来更新符合条件的数据库记录");
    }
    sb.append(",");
    sb.append(introspectedTable.getFullyQualifiedTable());
    addJavaDocLine(method, sb);

    final List<Parameter> parameterList = method.getParameters();
    if (!parameterList.isEmpty()) {
      method.addJavaDocLine(" *");
      if ("or".equals(method_name)) {
        sb.append(" 增加或者的查询条件,用于构建或者查询");
      }
    } else {
      if ("or".equals(method_name)) {
        sb.append(" 创建一个新的或者查询条件");
      }
    }
    String paramterName;
    for (Parameter parameter : parameterList) {
      sb.setLength(0);
      sb.append(" * @param "); //$NON-NLS-1$
      paramterName = parameter.getName();
      sb.append(paramterName);
      if ("orderByClause".equals(paramterName)) {
        sb.append(" 排序字段"); //$NON-NLS-1$
      } else if ("distinct".equals(paramterName)) {
        sb.append(" 是否过滤重复数据");
      } else if ("criteria".equals(paramterName)) {
        sb.append(" 过滤条件实例");
      }
      addJavaDocLine(method, sb);
    }

    method.addJavaDocLine(" */"); //$NON-NLS-1$
  }


  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {
    // 添加字段注释
    StringBuffer sb = new StringBuffer();
    field.addJavaDocLine("/**");
    if (introspectedColumn.getRemarks() != null) {
      field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
    }
    sb.append(" * 表字段 : ");
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    field.addJavaDocLine(sb.toString());

    // addJavadocTag(field, false);
    field.addJavaDocLine(" */");
  }

  @Override
  public void addGetterComment(Method method,
      IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {
    StringBuilder sb = new StringBuilder();

    method.addJavaDocLine("/**"); //$NON-NLS-1$
//        method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$

    sb.append(" * 获取 "); //$NON-NLS-1$
    sb.append(introspectedColumn.getRemarks()).append(" 字段:");
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    addJavaDocLine(method, sb);

    method.addJavaDocLine(" *"); //$NON-NLS-1$

    sb.setLength(0);
    sb.append(" * @return "); //$NON-NLS-1$
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    sb.append(", ");
    sb.append(introspectedColumn.getRemarks());
    addJavaDocLine(method, sb);

//        addJavadocTag(method, false);
    method.addJavaDocLine(" */"); //$NON-NLS-1$
  }

  @Override
  public void addSetterComment(Method method,
      IntrospectedTable introspectedTable,
      IntrospectedColumn introspectedColumn) {

    StringBuilder sb = new StringBuilder();

    method.addJavaDocLine("/**"); //$NON-NLS-1$
//        method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$

    sb.append(" * 设置 ");  //$NON-NLS-1$
    sb.append(introspectedColumn.getRemarks()).append(" 字段:");
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    addJavaDocLine(method, sb);

    method.addJavaDocLine(" *"); //$NON-NLS-1$

    Parameter parm = method.getParameters().get(0);
    sb.setLength(0);
    sb.append(" * @param "); //$NON-NLS-1$
    sb.append(parm.getName());
    sb.append(" the value for "); //$NON-NLS-1$
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    sb.append(", ");
    sb.append(introspectedColumn.getRemarks());
    addJavaDocLine(method, sb);

    method.addJavaDocLine(" */"); //$NON-NLS-1$
  }

  /**
   *
   * @param method
   * @param sb
   */
  private void addJavaDocLine(Method method, StringBuilder sb) {
    method.addJavaDocLine(sb.toString());
  }

}