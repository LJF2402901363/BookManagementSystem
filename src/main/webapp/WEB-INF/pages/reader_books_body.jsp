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
        <th>ID</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>ISBN</th>
        <th>价格</th>
        <th>剩余数量</th>
        <th>操作</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>序号</th>
        <th>ID</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>ISBN</th>
        <th>价格</th>
        <th>剩余数量</th>

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
                   图书详细
                </h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form action="#" method="post" id="addForm" >

                        <div class="input-group">
                            <span  class="input-group-addon">书名</span>
                            <input type="text" class="form-control" name="name" id="name" >
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">作者</span>
                            <input type="text" class="form-control" name="author" id="author" >
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">出版社</span>
                            <input type="text" class="form-control" name="publish" id="publish"   >
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">ISBN</span>
                            <input type="text" class="form-control" name="isbn" id="isbn"   >
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">简介</span>
                            <input type="text" class="form-control" name="introduction" id="introduction" >
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">语言</span>
                            <input type="text" class="form-control" name="language" id="language"  >
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">价格</span>
                            <input type="text" class="form-control" name="price"  id="price" >
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">出版日期</span>
                            <input type="date" class="form-control" name="pubstr" id="pubstr" >
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">分类号</span>
                            <input type="text" class="form-control" name="classId" id="classId">
                        </div>
                        <div class="input-group">
                            <span  class="input-group-addon">数量</span>
                            <input type="text" class="form-control" name="number"  id="number" >
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
            buttons: [
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
                { "data": "bookId" },
                { "data": "name" },
                { "data": "author" },
                { "data": "publish" },
                { "data": "isbn" },
                { "data": "price" },
                { "data": "number" },
                {
                    data: null,
                    title: '操作',
                    width: "10%",
                    render: function(data, type, row, meta) {
                        return '<div class="text-center">'
                            +'<button type="button" class="btn btn-block btn-danger btn-sm" id="detailBtn" data-toggle="modal" data-target="#myModal">详情</button>'
                            +'<button type="button" class="btn btn-block btn-info btn-sm" id="lendBookBtn" >借阅</button>'
                            +'</div>';
                    }
                }
            ],
            "deferRender": true,
            // 服务器端处理方式
            "serverSide": true,
            // 也可以用对象来配置，更加灵活
            "ajax": {
                // url可以直接指定远程的json文件，或是MVC的请求地址 /Controller/Action
                url: "${pageContext.request.contextPath}/book/findAll.do",//请求地址
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
        //给操作列的借书按钮添加点击事件
        $("#productTable tbody").on("click", "#lendBookBtn", function() {

            // //获取行
            var row = table.row($(this).closest('tr')).data();
            $.ajax({
                "url":"${pageContext.request.contextPath}/lendbook.html",
                "type":"POST",
                "data":{"bookId":row.bookId,"readerId":${readercard.readerId}},
                "dataType":"json",
                "success":function (data) {
                    if (data.status== 1){
                        alert(data.msg);
                        table.ajax.reload();
                    }else{
                        alert(data.msg);
                    }

                },
                "error":  function (XMLHttpRequest, textStatus, errorThrown) {
                    confirm("删除时发生异常！");
                }
            })
        });
        //给详细按钮添加点击事件
        $("#productTable tbody").on("click", "#detailBtn", function() {
            // //获取行
            var row = table.row($(this).closest('tr')).data();
            // alert("aa");
            $("#name").attr('value',row.name);
            $("#author").attr('value',row.author);
            $("#publish").attr('value',row.publish);
            $("#isbn").attr('value',row.isbn);
            $("#number").attr('value',row.number);
            $("#price").attr('value',row.price);
            $("#language").attr('value',row.language);
            $("#introduction").attr('value',row.introduction);
            $("#classId").attr('value',row.classId);
            $("#pubstr").attr('value',row.pubstr);
        });
        

        
    });


</script>