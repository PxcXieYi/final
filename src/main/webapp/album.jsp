<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>


    <script type="text/javascript">
        //菜单处理
        $(function () {
            $("#myTreegrid").treegrid({
                url:"${pageContext.request.contextPath}/main/selectAllAlbum",
                idField:'id',
                treeField:'title',
                fit: true,
                fitColumns: true,
                pagination:true,
                pageList:[5,10,15,20],
                pageSize:5,
                columns:[[
                    {title:"名字",field:"title",width: 100},
                    {title:"下载路径",field:"url",width: 100},
                    {title:"章节大小",field:"size",width: 100},
                    {title:"章节时长",field:"duration",width: 100},
                ]],
                toolbar:"#myTool",
             });
            $("#addDiv1").dialog({
                title: '添加专辑',
                width: 400,
                height: 200,
                closed: true,
                buttons:'#submitForm1'
            });
            $("#addDiv2").dialog({
                title: '添加详情',
                width: 400,
                height: 200,
                closed: true,
                buttons:'#submitForm2'
            })

        });
        function toAddAlbum(){
            $("#addDiv1").dialog("open");
        }
        function toAddChapter(){
            $("#addDiv2").dialog("open");
        }
        //添加专辑
        function Album(){
            alert("hahah111111111")
            $("#addForm1").form("submit",{
                url:"${pageContext.request.contextPath}/main/insertAlbum",
                success:function(data){
                    alert(data)
                    if(data=="true"){
                        $.messager.alert("我的消息","添加成功","question");
                        $("#addDiv1").dialog("close");


                    }else{
                        $.messager.alert("我的消息","添加失败","warning");
                        $("#addDiv1").dialog("close");

                    }
                }

            });
        }
        //添加章节
        function Chapter(){
            alert("hahah22222222222")
            $("#addForm2").form("submit",{
                url:"${pageContext.request.contextPath}/main/insertChapter",
                success:function(data){
                    alert(data)
                    if(data=="true"){
                        $.messager.alert("我的消息","添加成功","question");
                        $("#addDiv2").dialog("close");


                    }else{
                        $.messager.alert("我的消息","添加失败","warning");
                        $("#addDiv2").dialog("close");

                    }
                }

            });
        }

    </script>


<table id="myTreegrid" style="width:600px;height:400px"></table>
<!-- 工具按钮 -->
<div id="myTool">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-tip'" onclick="toAlbumDetails()">专辑详情</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-filesave'" onclick="toAddAlbum()">添加专辑</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-filesave'" onclick="toAddChapter()">添加章节</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-undo'" onclick="toUploadAudio()">下载音频</a>
</div>
<%--添加专辑--%>
<div id="addDiv1">
    <form action="" id="addForm1" method="post" enctype="multipart/form-data">
        专辑名字：<input name="title"/><br>
        封面图片： <input name="file1" type="file" class="offset10 lf"  /><br>
        专辑的数量：<input name="count"/><br>
        专辑的评分：<input name="score"/><br>
        专辑的作者：<input name="author"/><br>
        音频的播音人：<input name="broadCast"/><br>
        专辑的简介：<input name="brief"/><br>
    </form>
    <div id="submitForm1"><a class="easyui-linkbutton" onclick="Album()">提交</a></div>
</div>
<%--添加章节--%>
<div id="addDiv2">
    <form action="" id="addForm2" method="post" >
        章节音频的名字： <input name="title"/><br>
        状态：<input name="url"/><br>
        章节音频的大小：<input name="size"/><br>
        章节音频的时长：<input name="duration"/><br>
    </form>
    <div id="submitForm2"><a class="easyui-linkbutton" onclick="Chapter()">提交</a></div>
</div>


