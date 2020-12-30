<%--
  Created by IntelliJ IDEA.
  User: 陌意随影
  Date: 2020/9/9 0009
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<table id="productTable" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>读者ID</th>
        <th>读者姓名</th>
        <th>读者密码</th>
        <th>操作</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>序号</th>
        <th>读者ID</th>
        <th>读者姓名</th>
        <th>读者密码</th>
        <th>操作</th>
    </tr>
    </tfoot>
</table>
<!-- 模态框（Modal） -->
<div  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    更新日志
                </h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form action="#" method="post" id="addForm" >

                        <div class="input-group">
                            <span  class="input-group-addon">读者ID</span>
                            <input type="text" class="form-control" name="readerId" id="readerId" >
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">读者姓名</span>
                            <input type="text" class="form-control" name="username" id="username" >
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">读者密码</span>
                            <input type="text" class="form-control" name="password" id="password"   >
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" id="updateBookModalBtn">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>
    <!-- /.modal -->
<!-- Page specific script -->
<script>
    $(function () {
        var table = $("#productTable").DataTable({
            // 是否允许检索
            "searching": true,
            // 是否允许排序
            "ordering": true,
            "info": true,
            // 是否允许翻页，设成false，翻页按钮不显示
            "paging": true,
            // 水平滚动条
            "scrollX": false,
            // 垂直滚动条
            "scrollY": false,
            // 件数选择功能 默认true
            "lengthChange": true,
            // 件数选择下拉框内容
            "lengthMenu": [10, 25, 50, 75, 100],
            // 每页的初期件数 用户可以操作lengthMenu上的值覆盖
            "pageLength": 10,
            "pagingType": "full_numbers",
            "stripeClasses": ['strip1', 'strip2', 'strip3'],
            // 是否表示 "processing" 加载中的信息，这个信息可以修改
            "processing": true,
            // 每次创建是否销毁以前的DataTable,默认false
            "destroy": false,
            // 控制表格各种信息的表示位置（比较复杂） 默认:lfrtip
            "language": {
                "processing": "加载中",
                "buttons": {
                    "pageLength": {
                        "_": "显示%d条",
                        '-1': "全部显示"
                    }
                },
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "末页"
                },
                "info": "共 _TOTAL_ 条记录,当前第_PAGE_页,共_PAGES_页",
                "infoEmpty": "未找到相关数据",
                "search": "关键字",
                "zeroRecords": "未找到相关数据",
                "decimal": ".",
                "thousands": ","
            },
            // 自动列宽
            "autoWidth": true,
            dom: 'Bfrtip',
            buttons: [{
                text: '新建',
                className: "btn btn-primary",
                action: function(e, dt, node, config) {

                }
            },
                {
                    text: '删除',
                    className: "btn btn-primary",
                    action: function(e, dt, node, config) {

                    }
                },
                {
                    text:"刷新",
                    className: "btn btn-primary",
                    action: function(e, dt, node, config) {
                        dt.ajax.reload();
                    }
                },
                {
                    extend: 'excel',
                    text:"导出表格",
                    className: "btn btn-primary"
                }
            ],
            "columns": [
                {
                    title: '序号',
                    data: null,
                    className: 'text-center whiteSpace',
                    render:function(data,type,row,meta) {
                        return meta.row + 1 +meta.settings._iDisplayStart;
                    }
                },
                { "data": "readerId" },
                { "data": "username" },
                { "data": "password" },
                {
                    data: null,
                    title: '操作',
                    width: "10%",
                    render: function(data, type, row, meta) {
                        return '<div class="text-center">'+'<button type="button" class="btn btn-block btn-danger btn-sm" id="detailBtn" data-toggle="modal" data-target="#myModal">详情</button>'
                            +'<button type="button" class="btn btn-block btn-danger btn-sm" id="deleteProductBtn" >删除</button>'
                            +'<button type="button" class="btn btn-block btn-info btn-sm" id="updateProductBtn" data-toggle="modal" data-target="#myModal">修改</button></div>';
                    }
                }
            ],
            "deferRender": true,
            // 服务器端处理方式
            "serverSide": true,
            // 也可以用对象来配置，更加灵活
            "ajax": {
                // url可以直接指定远程的json文件，或是MVC的请求地址 /Controller/Action
                url: "${pageContext.request.contextPath}/readCard/findAll.do",//请求地址
                type: 'POST',
                // 传给服务器的数据，可以添加我们自己的查询参数
                data: function (param) {
                    param.opportunityNO = $('#txtSearch').val();
                    return param;
                },
                //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
                dataSrc: function (json) {
                    json.recordsTotal=json.total;
                    json.recordsFiltered=json.total;
                    json.data=json.list;
                    return json.data;
                }
            },
        });
        //给操作列的删除按钮添加点击事件
        $("#productTable tbody").on("click", "#deleteProductBtn", function() {

            // //获取行
            var row = table.row($(this).closest('tr')).data();

            $.ajax({
                "url":"${pageContext.request.contextPath}/deleteReaderCard",
                "type":"POST",
                "data":{"readerId":row.readerId},
                "dataType":"json",
                "success":function (data) {
                    if (data.status== 1){
                        alert("删除成功！");
                        table.ajax.reload();
                    }else{
                        alert("删除失败！")
                    }

                },
                "error":  function (XMLHttpRequest, textStatus, errorThrown) {
                    confirm("删除时发生异常！");
                }
            })
        });
        //给操作列的更改按钮添加点击事件
        $("#productTable tbody").on("click", "#updateProductBtn", function() {

            // //获取行
            var row = table.row($(this).closest('tr')).data();
            // alert("aa");
            $("#readerId").attr('value',row.readerId);
            $("#username").attr('value',row.username);
            $("#passwd").attr('value',row.password);
            $("#myModalLabel").html("更新借阅卡");
        });
        //给详细按钮添加点击事件
        $("#productTable tbody").on("click", "#detailBtn", function() {


            // //获取行
            var row = table.row($(this).closest('tr')).data();
            $("#readerId").attr('value',row.readerId);
            $("#username").attr('value',row.username);
            $("#passwd").attr('value',row.password);
            $("#myModalLabel").html("详细");
        });
        
        $("#updateBookModalBtn").click(function (){
            if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubstr").val()==''||$("#classId").val()==''||$("#number").val()==''){
                alert("请填入完整图书信息！");
                return ;
            }
            var fields = $('#addForm').serializeArray();
            var obj = {}; //声明一个对象
            $.each(fields, function(index, field) {
                obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
            })
            $.ajax({
                "url":"${pageContext.request.contextPath}/updateReaderCard",
                "type":"POST",
                "contentType" : 'application/json;charset=utf-8',
                "data":JSON.stringify(obj),
                "dataType":"json",
                "success":function (data) {
                    if (data.status== 1){
                        alert("更新成功！")
                        dt.ajax.reload();
                    }else{
                        alert("更新失败！")
                    }

                },
                "error":  function (XMLHttpRequest, textStatus, errorThrown) {
                    confirm("更新时发生异常！");
                }
            })
            
        });
        
    });


</script>