<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        //菜单处理-
        $(function () {
            $("#myDatagrid").edatagrid({
                updateUrl:"${pageContext.request.contextPath}/main/updateBanner",
                url:"${pageContext.request.contextPath}/main/selectAllBanner",
                fit: true,
                fitColumns: true,
                pagination:true,
                checkbox:true,
                pageList:[5,10,15,20],
                pageSize:5,
                columns:[[
                    {title:"名字",field:"name",width: 100},
                    {title:"状态",field:"status",width: 100,
                        formatter: function(value,rowData,rowindex){
                            if (value==0){
                                return "Y";
                            } else {
                                return "N";
                            }
                        },
                        editor: {
                            type: "text",
                            options: {
                                required: true
                            }
                        }
                        },

                    {title:"时间",field:"createDate",width: 100},
                    {title:"描述",field:"descr",width: 100},
                ]],
                toolbar:"#myTool",
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.url + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Description: ' + rowData.descr + '</p>' +
                        '<p>UploadTime: ' + rowData.createDate + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
        })
            $("#addDiv").dialog({
                title: '添加',
                width: 400,
                height: 200,
                closed: true,
                buttons:'#submitForm'
            })

        });
        function toAdd(){
            $("#addDiv").dialog("open");
        }
        //添加
        function tijiao(){
            alert("hahah")
            $("#addForm").form("submit",{
                url:"${pageContext.request.contextPath}/main/addBanner",
                success:function(data){
                    alert(data)
                    if(data=="true"){
                        $.messager.alert("我的消息","添加成功","question");
                        $("#addDiv").dialog("close");
                        $("#myDatagrid").datagrid("reload");

                    }else{
                        $.messager.alert("我的消息","添加失败","warning");
                        $("#addDiv").dialog("close");
                        $("#myDatagrid").datagrid("reload");
                    }
                }

            });
        }
        //删除
        function toDelete(){
            var arr = $("#myDatagrid").datagrid("getSelected");
            console.log(arr.id);
            if(arr!=0){
                $.messager.confirm("删除确认","真的要删除吗？",function(r){
                    if(r){
                        //发送ajax请求
                        $.ajax({
                            url:"${pageContext.request.contextPath}/main/delete",
                            //jQuery发送ajax请求的时候，防止jQuery对json格式的参数做深度序列
                            traditional:true,
                            //	data:{"ids":ids},
                            data:"id="+arr.id,
                            success:function(data){
                                if(data){
                                    //一个淡出的显示框
                                    $.messager.show({
                                        title:'我的消息',
                                        msg:'删除成功',
                                        timeout:5000,
                                        showType:'slide'
                                    });

                                }else{
                                    $.messager.show({
                                        title:'我的消息',
                                        msg:'删除失败',
                                        showType:'slide'
                                    });
                                }
                                //刷新
                                $("#myDatagrid").datagrid("reload");
                            }
                        })
                    }
                })
            }
        }
        //修改
        function toUpdate(){
            var data = $("#myDatagrid").datagrid("getSelected");
            console.log(data);
            if(data==null){
                alert("请先选中行")
            }else{
                var index = $("#myDatagrid").edatagrid("getRowIndex", data);
                $("#myDatagrid").edatagrid("editRow", index);
            }
        }
        //保存
        function toSave(){
            $("#myDatagrid").edatagrid("saveRow");
        }

    </script>


<table id="myDatagrid" ></table>
<!-- 工具按钮 -->
<div id="myTool">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toAdd()">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-pencil'" onclick="toUpdate()">修改</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="toDelete()">删除</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="toSave()">保存</a>
</div>
<%--添加--%>
<div id="addDiv">
    <form action="" id="addForm" method="post" enctype="multipart/form-data">
        名字：<input name="name"/><br>
        图片： <input name="file1" type="file" class="offset10 lf"  /><br>
        状态：<input name="status"/><br>
 <%--       创建时间：<input name="createDate" /><br>--%>
        描述信息：<input name="descr"/><br>
    </form>
    <div id="submitForm"><a class="easyui-linkbutton" onclick="tijiao()">提交</a></div>
</div>


