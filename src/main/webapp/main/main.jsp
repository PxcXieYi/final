<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	<!--菜单处理-->
    $(function () {
        $.ajax({
            type: "post",
            dataType: "JSON",
            url:"${pageContext.request.contextPath}/main/selectAll",
            success: function (data) {
                /*参数1：集合   参数2：元素下标  参数3：当前元素的名字*/
               // alert(data)
                $.each(data, function (index, first) {
                   // alert(index)
                    var c = "";
                    $.each(first.menuList, function (index1, second) {
                        c = "<div style='text-align: center'><a href='javascript:void(0)' class='easyui-linkbutton' data-options=\"iconCls:'"+second.iconCls+"',plain:true\" onclick=\"addTabs('" + second.title + "','" + second.url + "','" + second.iconCls + "')\">" + second.title + "</a></div>";
                    })
                    $('#aa').accordion('add', {
                        title: first.title,
                        content: c,
                        iconCls: first.iconCls,
                        selected: false
                    });
                })


            }

        })
    })
    function addTabs(title, url, iconCls) {
      //  alert("哈哈哈")
        var flag = $("#tt").tabs("exists", title);
        if (flag){
            $("#tt").tabs("select", title);
        }else {
            $('#tt').tabs('add', {
                title: title,
                selected: true,
                iconCls: iconCls,
                href: "${pageContext.request.contextPath}/" +url,
                closable:true
            })
        }
    }





</script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
           <%-- <c:forEach var="menus" items="${sessionScope.menus}">
                <div title="${menus.title}" data-options="iconCls:'${menus.iconCls}'" style="overflow:auto;padding:10px;">
                    <c:forEach var="list" items="${menus.menuList}">
                        <div   style="text-align: center"   >
                               <a href="#" class='easyui-linkbutton'
                                  data-options="iconCls:'${list.iconCls}',plain:true"
                                   onclick="addTabs('${list.title}','${list.url}','${list.iconCls}')">${list.title}</a>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>--%>

        </div>


    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>
    </div>
</body>
</html>