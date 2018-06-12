<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>资产管理二维码</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/jquery-qrcode/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/jquery-qrcode/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {

      <%--//显示二维码--%>
      var assetsManagerId = '${assetsManager.id}';
      var url = '${fns:getModuleLink('assets')}/assets/assetsManager/api/' + assetsManagerId;
      if (assetsManagerId != '') {
        $('#assets_qrcode').qrcode({
          'width': 150,
          'height': 150,
          'render': 'canvas',
          'text': url
        });

        var img = document.getElementById("image"); // get image element
        var canvas = document.getElementsByTagName("canvas")[0];  // get canvas element
        img.src = canvas.toDataURL();                     // update image
      }

      $("#btnPrint").click(function () {
        //这里不能使用jq的选择器来获取，不然报错
        $("#root-element").jqprint({
          debug: false,
          importCSS: true,
          printContainer: true,
          operaSupport: false
        });
      });
    });
    </script>
</head>
<body>
<div class="container">

    <div style="text-align: right">
        <button id="btnPrint" class="btn btn-primary">打印</button>
    </div>

    <div id="root-element">

        <div class="form-group form-inline">
            <label>资产编号：</label>
            ${assetsManager.assetsNo}

            <label></label>

            <label>资产名称：</label>
            ${assetsManager.assetsNo}

            <label></label>

        </div>

        <div class="form-group form-inline">
            <label>资产序列号：</label>
            ${assetsManager.assetsSerialNum}
            <label></label>
        </div>

        <div style="text-align: center">
            <img id="image" src=""/>
        </div>


    </div>

    <div class="form-group" style="text-align: center">
        <div class="form-group">
            <div id="assets_qrcode" style="display: none"></div>
        </div>

    </div>
</div>
</body>
</html>
