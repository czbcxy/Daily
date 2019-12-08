<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%--<%@ page import="java.io.*,java.util.*" %>--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>EasyUI入门——创建EasyUI的Dialog</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <!-- 引入JQuery -->
    <script type="text/javascript" src="../jquery-easyui-1.5.3/jquery.min.js"></script>
    <!-- 引入EasyUI -->
    <script type="text/javascript"
            src="../jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
    <script type="text/javascript"
            src="../jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="../jquery-easyui-1.5.3/themes/default/easyui.css"
          type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="../jquery-easyui-1.5.3/themes/icon.css"
          type="text/css"/>
    <%--<script type="text/javascript">--%>
    <%--$(function () {--%>
    <%--console.info($('#dd2'));--%>
    <%--/*使用JavaScript动态创建EasyUI的Dialog的步骤：--%>
    <%--1、定义一个div，并给div指定一个id--%>
    <%--2、使用Jquery选择器选中该div，然后调用dialog()方法就可以创建EasyUI的Dialog--%>
    <%--*/--%>
    <%--$('#dd2').dialog();//使用默认的参数创建EasyUI的Dialog--%>
    <%--//使用自定义参数创建EasyUI的Dialog--%>
    <%--$('#dd3').dialog({--%>
    <%--title: '使用JavaScript创建的Dialog',--%>
    <%--width: 400,--%>
    <%--height: 200,--%>
    <%--closed: false,--%>
    <%--cache: false,--%>
    <%--modal: true--%>
    <%--});--%>
    <%--});--%>
    <%--</script>--%>

</head>

<body>
<%--使用纯html的方式创建创建EasyUI的Dialog的步骤：
1、定义一个div
2、将div的class样式属性设置成easyui-dialog，这样就可以将普通的div变成EasyUI的Dialog了
 --%>
<%--<div class="easyui-dialog" id="dd1" title="EasyUI Dialog" style="width: 500px;height: 300px;">--%>
<%--Hello World!--%>
<%--</div>--%>
<%--<div id="dd2" class="easyui-dialog" title="EasyUI Dialog" style="width: 300px;height: 200px;">Dialog Content</div>--%>
<%--<div id="dd3"  class="easyui-dialog" title="EasyUI Dialog" style="width: 200px;height: 100px;">Dialog Content</div>--%>
<%--<h2>自动刷新时间:</h2>--%>
<%--<%--%>
<%--// 设置每隔5秒刷新一次--%>
<%--response.setIntHeader("Refresh", 5);--%>
<%--// 获取当前时间--%>
<%--Calendar calendar = new GregorianCalendar();--%>
<%--String am_pm;--%>
<%--int hour = calendar.get(Calendar.HOUR);--%>
<%--int minute = calendar.get(Calendar.MINUTE);--%>
<%--int second = calendar.get(Calendar.SECOND);--%>
<%--if(calendar.get(Calendar.AM_PM) == 0)--%>
<%--am_pm = "AM";--%>
<%--else--%>
<%--am_pm = "PM";--%>
<%--String CT = hour+":"+ minute +":"+ second +" "+ am_pm;--%>
<%--out.println("当前时间为: " + CT + "\n");--%>
<%--%>--%>

<%--<jsp:include page="jsp/head.jsp"></jsp:include>--%>


<%--<div id="p" class="easyui-panel" title="My Panel"--%>
<%--style="width:20%;height:400px;padding:10px;background:#fafafa;"--%>
<%--data-options="iconCls:'icon-save',closable:true,--%>
<%--collapsible:true,minimizable:true,maximizable:true">--%>

<%--<ul id="tt" class="easyui-tree">--%>
<%--<li>--%>
<%--<span>Folder</span>--%>
<%--<ul>--%>
<%--<li>--%>
<%--<span>Sub Folder 1</span>--%>
<%--<ul>--%>
<%--<li><span><a href="http://www.baidu.com">File 11</a></span></li>--%>
<%--<li><span>File 12</span></li>--%>
<%--<li><span>File 13</span></li>--%>
<%--</ul>--%>
<%--</li>--%>
<%--<li><span>File 2</span></li>--%>
<%--<li><span>File 3</span></li>--%>
<%--</ul>--%>
<%--</li>--%>
<%--<li><span>File21</span></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--<body class="easyui-layout">--%>
<%--<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>--%>
<%--&lt;%&ndash;<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>&ndash;%&gt;--%>
<%--<div data-options="region:'east',title:'East',split:true" style="width:180px;"></div>--%>
<%--<div data-options="region:'west',title:'West',split:true" style="width:180px;"></div>--%>
<%--<div data-options="region:'center',title:'center title'" style="padding:10px;background:#eee;"></div>--%>
<%--</body>--%>

<div>
    <button type="button" onclick="submit()">点我提交</button>
</div>
<script type='text/javascript'>
    var data ={
        "payId": "1513219717093004",
        "sign": "100",
        "sign_type": "MD5",
        "oid_partner": "300",
        "dt_order": "100",
        "no_order": "100",
        "oid_paybill": "100",
        "money_order": "100",
        "result_pay": "100",
        "settle_date": "100",
        "info_order": "100",
        "pay_type": "100",
        "bank_code": "100"
    };

    function submit() {
        $.ajax({
            type: "POST",
            url: "http://127.0.0.1:8080/ledong-p2c-webapps-wwwp/notify/notifyController",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (data) {
               alert("请求已提交！我们会尽快与您取得联系" + data);
            },
            error: function (data) {
                alert("提交数据失败！" + data);
            }
        });
    }
//     $(function(){
//        $.getJSON('./db.json', function (result) {
//            $.getElementById("div").innerHTML(result);
//        })
//    })

</script>
<%--<div id="div">--%>
<%--</div>--%>

</body>
</html>