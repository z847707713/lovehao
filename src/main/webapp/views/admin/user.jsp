<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="../common/index-header.jsp" />
<body class="sidebar-fixed header-fixed">

<div style="width:80%; position: absolute;
            left:50%;
            top:50%;
           transform: translate(-50%,-50%);">

    <div class="card">

        <div class="card-body">
            <form id="formData">
                <input type="hidden" name="id" value="${permission.id}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="permission" class="form-control-label">权限</label>
                            <input name="permission" id="permission" class="form-control" value="${permission.permission}">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="permissionName" class="form-control-label">权限名称</label>
                            <input name="permissionName" id="permissionName"  class="form-control" value="${permission.permissionName}">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="desc" class="form-control-label">权限描述</label>
                            <input name="permissionDesc" id="desc"  class="form-control" value="${permission.permissionDesc}">
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </div>

</div>
<script>


</script>

</body>
<jsp:include page="../common/footer.jsp" />