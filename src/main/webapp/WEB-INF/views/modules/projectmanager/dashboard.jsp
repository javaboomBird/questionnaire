<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>项目管理驾驶舱</title>
    <meta name="decorator" content="default"/>
    <%--<link href="${ctxStatic}/bootstrap/2.3.1/dashboard/bootstrap-responsive.min.css" type="text/css"--%>
          <%--rel="stylesheet"/>--%>
    <link href="${ctxStatic}/bootstrap/2.3.1/dashboard/styles.css" type="text/css"
          rel="stylesheet"/>

    <style type="text/css">

        .square {
            width: 100px;
            height: 100px;
            background: #7fee1d;
            -moz-border-radius: 50px;
            -webkit-border-radius: 50px;
            border-radius: 50px;
        }
    </style>
    <script type="text/javascript">
    $(document).ready(function () {

    });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/projectmanager/project/">项目管理驾驶舱</a></li>
    <li></li>
</ul>
<div class="container-fluid">
    <div class="span12">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        项目状态
                    </h4>
                </div>
                <div class="panel-body">
                    <c:forEach items="${projectStatus}" var="s">
                        <div class="span2" style="width: 100px">
                            <div class="span">
                                <a href="${ctx}/projectmanager/project/list?projectStatus=${s.key}">
                                    <div class="square">
                                        <span style="height:100px; line-height:100px; display:block; color:#FFF; text-align:center">${s.value}</span>
                                    </div>
                                </a>
                            </div>
                            <div style="width:120px;text-align: center ">
                                <span>${fns:getDictLabel(s.key,'project_status' ,'')}</span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="block">
                        <div class="navbar navbar-inner block-header">
                            <div class="muted pull-left"><h4>延期项目列表</h4></div>
                        </div>
                        <div class="block-content collapse in">
                            <div class="span12">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>项目名称</th>
                                        <th>项目编号</th>
                                        <th>负责人</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${delayProjectList}" var="delay_project"
                                               varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${delay_project.projectName}</td>
                                            <td>${delay_project.projectCode}</td>
                                            <td>${fns:getUserById(delay_project.managerId).name}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="block">
                        <div class="navbar navbar-inner block-header">
                            <div class="muted pull-left"><h4>未完成任务列表(工程/运维)</h4></div>
                        </div>
                        <div class="block-content collapse in">
                            <div class="span12">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>项目名称</th>
                                        <th>负责人</th>
                                        <th>未完成任务数</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${noCompleteTaskList}" var="task" varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${task.projectName}</td>
                                            <td>${fns:getUserById(task.managerId).name}</td>
                                            <td>${task.totalNum}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
