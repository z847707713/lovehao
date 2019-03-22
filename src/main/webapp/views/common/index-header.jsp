<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LOVE HAO</title>


    <!-- 只包含paginator 的样式 -->
    <link rel="stylesheet" href="/common/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/common/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/common/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/common/css/styles.css">


    <!-- jquery -->
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>

    <script src="/common/vendor/popper.js/popper.min.js"></script>
    <script src="/common/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/common/vendor/chart.js/chart.min.js"></script>
    <script src="/common/js/carbon.js"></script>
    <script src="/common/js/demo.js"></script>
    <script src="/common/plugin/bootstrap-paginator/bootstrap-paginator.min.js" ></script>
    <!--  序列化表单 -->
    <script src="/common/js/serialize.js" ></script>
    <!-- 弹出层layer -->
    <script src="/common/plugin/layer/layer.js" ></script>

    <!-- 菜单选中效果 -->
    <script src="/common/js/menu.js"> </script>

    <!-- 文本长度限制插件 -->
    <script src="/common/plugin/wordlimit/wordlimit.js"> </script>

    <!--  jquery UI -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    <!-- SweetAlert 对话框 -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!--  z-tree插件 -->
    <link rel="stylesheet" href="/common/plugin/zTree_v3/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
    <script src="/common/plugin/zTree_v3/js/jquery.ztree.core.js"></script>
    <script src="/common/plugin/zTree_v3/js/jquery.ztree.excheck.js"></script>

    <style>
        /* Chart.js */
        @-webkit-keyframes chartjs-render-animation
        {
            from{opacity:0.99}to{opacity:1}
        }
        @keyframes chartjs-render-animation
        {
            from{
                opacity:0.99
            }to {
                opacity:1
            }
        }
        .chartjs-render-monitor {
            -webkit-animation:chartjs-render-animation 0.001s;
            animation:chartjs-render-animation 0.001s;
        }

        .pagination ul{

        }
        .pagination li{

        }

    </style>
</head>
