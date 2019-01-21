<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/index-header.jsp" />

<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">

    <jsp:include page="../common/navbar.jsp" />
    <jsp:include page="../common/index-menu.jsp" />
    <div class="content">

        <div class="card">

            <div class="card-header bg-light">
                条件检索
                <button class="btn btn-primary" style="float: right;">search</button>
            </div>

            <div class="card-body">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="normal-input" class="form-control-label">Normal Input</label>
                            <input id="normal-input" class="form-control" value="Input value">
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="normal-input" class="form-control-label">Normal Input</label>
                            <input id="normal-input2" class="form-control" value="Input value">
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="normal-input" class="form-control-label">Normal Input</label>
                            <input id="normal-input3" class="form-control" value="Input value">
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-12">
                    <div class="form-group">

                    </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
                <div class="card-header bg-light">
                    角色列表
                </div>
           <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>角色名</th>
                        <th>角色描述</th>
                        <th>创建者</th>
                        <th>创建时间</th>
                        <th>更新者</th>
                        <th>更新时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td class="text-nowrap">Samsung Galaxy S8</td>
                        <td>31,589</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>删除</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td class="text-nowrap">Google Pixel XL</td>
                        <td>99,542</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>删除</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td class="text-nowrap">iPhone X</td>
                        <td>62,220</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>删除</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td class="text-nowrap">OnePlus 5T</td>
                        <td>50,000</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>删除</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td class="text-nowrap">Google Nexus 6</td>
                        <td>400</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>zh</td>
                        <td>2019-1-21</td>
                        <td>删除</td>
                    </tr>
                    </tbody>
                </table>
            </div>
          </div>
       </div>
    </div>
</div>
</div>


</body>
<jsp:include page="../common/footer.jsp" />

